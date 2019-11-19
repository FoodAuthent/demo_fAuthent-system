FROM openjdk:8-jre-alpine
MAINTAINER Sven Boeckelmann <sboeckelmann@benelog.com>

ENV FA_USER_TIMEZONE="Europe/Berlin"
ENV JVM_OPTS="-XX:+UseParallelGC"
ENV JAVA_OPTS="-Xms2g -Xmx2g"
ENV CFG_OPTS=""
ENV YJP="off"
ENV DEBUG="off"

RUN mkdir -p /opt/foodauthent
COPY maven/org.foodauthent.runtime /opt/foodauthent/runtime

COPY config /config
COPY bin /opt/foodauthent/bin
RUN chmod +x /opt/foodauthent/bin/run.sh

EXPOSE 9090/tcp
EXPOSE 9023/tcp
EXPOSE 9000/tcp

ENTRYPOINT ["/opt/foodauthent/bin/run.sh"]