#!/bin/sh
RUNTIME_OPTS="${JAVA_OPTS} ${JVM_OPTS} ${CFG_OPTS}"

#check if YourKit is enabled
case $YJP in [yY]|[yY][eE][sS]|[oO][nN]|1|[tT][rR][uU][eE])
	RUNTIME_OPTS="${RUNTIME_OPTS} -agentpath:/usr/local/YourKit-JavaProfiler-2019.1/bin/linux-x86-64/libyjpagent.so=port=10001,listen=all" ;; 
esac

#check if Debug is enabled
case $DEBUG in [yY]|[yY][eE][sS]|[oO][nN]|1|[tT][rR][uU][eE])
	RUNTIME_OPTS="${RUNTIME_OPTS} -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=9000" ;; 
esac

/usr/bin/java -Declipse.ignoreApp=true -Dosgi.noShutdown=true -Dorg.osgi.service.http.port=9090 \
 -Dorg.eclipse.equinox.http.jetty.http.host=0.0.0.0 -Djava.awt.headless=true -Dosgi.console=9023 -Dconfig.file=/config/fa.conf \
 ${RUNTIME_OPTS} -jar /opt/foodauthent/runtime/plugins/org.eclipse.equinox.launcher_1.4.0.v20161219-1356.jar
