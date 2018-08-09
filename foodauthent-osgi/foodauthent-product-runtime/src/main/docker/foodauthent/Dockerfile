FROM openjdk:8-jre-alpine
MAINTAINER Sven Boeckelmann <sboeckelmann@benelog.com>

ENV FA_USER_TIMEZONE="Europe/Berlin"
ENV JAVA_XMS="1g"
ENV JAVA_XMX="2g"

RUN mkdir -p /opt/foodauthent
COPY maven/org.foodauthent.runtime /opt/foodauthent/runtime

COPY bin /opt/foodauthent/bin
RUN chmod +x /opt/foodauthent/bin/run.sh
RUN chmod +x /opt/foodauthent/runtime/foodauthent-api

EXPOSE 9090/tcp
EXPOSE 9023/tcp

ENTRYPOINT ["/opt/foodauthent/bin/run.sh"]