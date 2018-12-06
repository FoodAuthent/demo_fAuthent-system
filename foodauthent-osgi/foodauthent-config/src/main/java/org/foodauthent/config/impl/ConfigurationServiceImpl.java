package org.foodauthent.config.impl;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.foodauthent.config.ConfigurationService;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.foodauthent.config.ConfigUtil;

public class ConfigurationServiceImpl implements ConfigurationService {

	private Config config;

	public ConfigurationServiceImpl() {
	}

	@Override
	public void reload() {
		ConfigFactory.invalidateCaches();
		this.config = ConfigFactory.load();
	}

	@Override
	public <T> Optional<T> get(Class<T> clazz, String path) {
		return ConfigUtil.get(clazz, config, path);
	}

	@Override
	public boolean hasPath(String path) {
		return config.hasPath(path);
	}

	@Override
	public boolean hasPathOrNull(String path) {
		return config.hasPathOrNull(path);
	}

	@Override
	public boolean isEmpty() {
		return config.isEmpty();
	}

	@Override
	public boolean getIsNull(String path) {
		return config.getIsNull(path);
	}

	@Override
	public boolean getBoolean(String path) {
		return config.getBoolean(path);
	}

	@Override
	public Number getNumber(String path) {
		return config.getNumber(path);
	}

	@Override
	public int getInt(String path) {
		return config.getInt(path);
	}

	@Override
	public long getLong(String path) {
		return config.getLong(path);
	}

	@Override
	public double getDouble(String path) {
		return config.getDouble(path);
	}

	@Override
	public String getString(String path) {
		return config.getString(path);
	}

	@Override
	public <T extends Enum<T>> T getEnum(Class<T> enumClass, String path) {
		return config.getEnum(enumClass, path);
	}

	@Override
	public Config getConfig(String path) {
		return config.getConfig(path);
	}

	@Override
	public long getDuration(String path, TimeUnit unit) {
		return config.getDuration(path, unit);
	}

	@Override
	public Duration getDuration(String path) {
		return config.getDuration(path);
	}

	@Override
	public Period getPeriod(String path) {
		return config.getPeriod(path);
	}

	@Override
	public TemporalAmount getTemporal(String path) {
		return config.getTemporal(path);
	}

	@Override
	public List<Number> getNumberList(String path) {
		return config.getNumberList(path);
	}

	@Override
	public List<Integer> getIntList(String path) {
		return config.getIntList(path);
	}

	@Override
	public List<Long> getLongList(String path) {
		return config.getLongList(path);
	}

	@Override
	public List<Double> getDoubleList(String path) {
		return config.getDoubleList(path);
	}

	@Override
	public List<String> getStringList(String path) {
		return config.getStringList(path);
	}

	@Override
	public <T extends Enum<T>> List<T> getEnumList(Class<T> enumClass, String path) {
		return config.getEnumList(enumClass, path);
	}

	@Override
	public List<Long> getDurationList(String path, TimeUnit unit) {
		return config.getDurationList(path, unit);
	}

	@Override
	public List<Duration> getDurationList(String path) {
		return config.getDurationList(path);
	}

	@Override
	public List<? extends Config> getConfigList(String path) {
		return config.getConfigList(path);
	}
	
}
