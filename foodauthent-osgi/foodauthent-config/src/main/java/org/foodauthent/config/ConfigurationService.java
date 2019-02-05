package org.foodauthent.config;

import java.io.InputStream;
import java.io.Reader;
import java.time.Duration;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.typesafe.config.Config;

public interface ConfigurationService {

	void reload();

	<T> Optional<T> get(Class<T> clazz, String path);

	boolean hasPath(String path);

	boolean hasPathOrNull(String path);

	boolean isEmpty();

	boolean getIsNull(String path);

	boolean getBoolean(String path);

	Number getNumber(String path);

	int getInt(String path);

	long getLong(String path);

	double getDouble(String path);

	String getString(String path);

	<T extends Enum<T>> T getEnum(Class<T> enumClass, String path);

	Config getConfig(String path);

	long getDuration(String path, TimeUnit unit);

	Duration getDuration(String path);

	Period getPeriod(String path);

	TemporalAmount getTemporal(String path);

	List<Number> getNumberList(String path);

	List<Integer> getIntList(String path);

	List<Long> getLongList(String path);

	List<Double> getDoubleList(String path);

	List<String> getStringList(String path);

	<T extends Enum<T>> List<T> getEnumList(Class<T> enumClass, String path);

	List<Long> getDurationList(String path, TimeUnit unit);

	List<Duration> getDurationList(String path);

	List<? extends Config> getConfigList(String path);

	void load(ClassLoader loader, String resourceBasename);

	void load(Reader reader);

	void load(Map<String, ? extends Object> values);

	void load(InputStream in);

	void reload(InputStream in);

	void reload(Reader reader);

	void reload(ClassLoader loader, String resourceBasename);
	
	Optional<Properties> getProperties(String path);

}