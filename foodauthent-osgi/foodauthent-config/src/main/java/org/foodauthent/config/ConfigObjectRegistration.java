package org.foodauthent.config;

import java.util.Optional;
import java.util.function.Consumer;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

public abstract class ConfigObjectRegistration<T extends ConfigObject> extends DefaultConfigurationListener {

	private Class<T> cls;

	private BundleContext context;

	private ServiceRegistration<T> serviceRegistration;

	private Optional<T> config = Optional.empty();

	protected ConfigObjectRegistration(final Class<T> cls) {
		this.cls = cls;
	}

	protected ConfigObjectRegistration(final Class<T> cls, final Consumer<ConfigurationService> consumer) {
		this(cls);
		super.consumer = Optional.ofNullable(consumer);
	}

	protected ConfigObjectRegistration(final Class<T> cls, final String path) {
		this(cls);
		super.consumer = Optional.of(new Consumer<ConfigurationService>() {

			@Override
			public void accept(ConfigurationService configurationService) {
				update(buildConfig(configurationService, path));
			}
		});
	}

	protected Optional<T> buildConfig(final ConfigurationService configurationService, final String path) {
		return configurationService.get(cls, path);
	}

	@Activate
	public void activate(final BundleContext context) {
		this.context = context;
		update(this.config);
	}

	@Deactivate
	public void deactivate(final BundleContext context) {
		if (serviceRegistration != null) {
			serviceRegistration.unregister();
		}
		this.serviceRegistration = null;
		this.config = Optional.empty();
		this.context = null;
	}

	private final void update(final Optional<T> config) {
		T cfg = null;
		if (context != null && config.isPresent()) {
			if (!this.config.isPresent()) {
				cfg = config.get();
			} else {
				// check if member config or changed config was passed as parameter
				if (this.config == config) {
					// setup new config
					cfg = config.get();
				} else {
					// setup config only if changed
					cfg = this.config.get().equals(config.get()) ? null : config.get();
				}
			}
		}
		if (cfg != null) {
			if (serviceRegistration != null) {
				serviceRegistration.unregister();
			}
			serviceRegistration = context.registerService(cls, cfg, null);
		}
	}

}
