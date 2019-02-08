#!/bin/sh
/usr/bin/java -Xms128m -Xmx2g -Declipse.ignoreApp=true -Dosgi.noShutdown=true -Dorg.osgi.service.http.port=9090 \
 -Dorg.eclipse.equinox.http.jetty.http.host=0.0.0.0 -Dosgi.console=9023 -Dconfig.file=/config/fa.conf \
  -jar /opt/foodauthent/runtime/plugins/org.eclipse.equinox.launcher_1.4.0.v20161219-1356.jar
