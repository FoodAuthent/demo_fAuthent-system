package org.foodauthent.config;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.validation.constraints.NotNull;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DefaultConfigurationListener implements ConfigurationListener {

	protected Optional<Consumer<ConfigurationService>> consumer = Optional.empty();

	public DefaultConfigurationListener() {
	}
	
	public DefaultConfigurationListener(final Consumer<ConfigurationService> c) {
		consumer = Optional.ofNullable(c);
	}

	@Override
	public void loaded(final ConfigurationService configurationService) {
		if (consumer.isPresent()) {
			consumer.get().accept(configurationService);
		}
	}

	public static final DefaultConfigurationListener create(@NotNull final Consumer<ConfigurationService> c) {
		return new DefaultConfigurationListener(c);
	}

	public static final Supplier<ServiceRegistration<ConfigurationListener>> register(final BundleContext bundleContext,
			@NotNull final Consumer<ConfigurationService> c) {
		final DefaultConfigurationListener configurationListener = create(c);
		final ServiceRegistration<ConfigurationListener> serviceRegistration = bundleContext
				.registerService(ConfigurationListener.class, configurationListener, null);
		final Supplier<ServiceRegistration<ConfigurationListener>> supplier = new Supplier<ServiceRegistration<ConfigurationListener>>() {

			@Override
			public ServiceRegistration<ConfigurationListener> get() {
				return serviceRegistration;
			}
		};
		return supplier;
	}

}
