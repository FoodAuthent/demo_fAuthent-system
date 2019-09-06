#!/bin/sh
/usr/bin/java -Xms${JAVA_XMS} -Xmx${JAVA_XMX} -Declipse.ignoreApp=true -Dosgi.noShutdown=true -Dorg.osgi.service.http.port=9090 \
 -Dorg.eclipse.equinox.http.jetty.http.host=0.0.0.0 -Djava.awt.headless=true -Dosgi.console=9023 -Dconfig.file=/config/fa.conf \
  -jar /opt/foodauthent/runtime/plugins/org.eclipse.equinox.launcher_1.4.0.v20161219-1356.jar
