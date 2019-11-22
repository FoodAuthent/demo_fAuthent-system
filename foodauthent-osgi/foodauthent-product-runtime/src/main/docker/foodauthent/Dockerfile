FROM openjdk:8-jdk-stretch
MAINTAINER Sven Boeckelmann <sboeckelmann@benelog.com>

ENV FA_USER_TIMEZONE="Europe/Berlin"
ENV JVM_OPTS="-XX:+UseParallelGC"
ENV JAVA_OPTS="-Xms2g -Xmx2g"
ENV CFG_OPTS=""
ENV YJP="off"
ENV DEBUG="off"
ENV HEADLESS="off"

RUN apt-get update
RUN apt-get -y upgrade
RUN apt-get -y install xvfb libxrender1 libxtst6

# setup YourKit 
ADD https://www.yourkit.com/download/docker/YourKit-JavaProfiler-2019.1-docker.zip /tmp
RUN  unzip /tmp/YourKit-JavaProfiler-2019.1-docker.zip -d /usr/local && \
  rm /tmp/YourKit-JavaProfiler-2019.1-docker.zip
  
RUN mkdir -p /opt/foodauthent
COPY maven/org.foodauthent.runtime /opt/foodauthent/runtime

COPY config /config
COPY bin /opt/foodauthent/bin
RUN chmod +x /opt/foodauthent/bin/run.sh

EXPOSE 9090/tcp
EXPOSE 9023/tcp
EXPOSE 9000/tcp
EXPOSE 10001/tcp

ENTRYPOINT ["/opt/foodauthent/bin/run.sh"]