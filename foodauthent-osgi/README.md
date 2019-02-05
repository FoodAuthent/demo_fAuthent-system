## java

Java projects and sources

required Docker containers:

ApacheDS
docker create --name apacheds-fa -p 10389:10389 docker-registry.foodauthent.net/apacheds:latest
docker start apacheds-fa

docker create --name es6-fa -p 9200:9200 -p 9300:9300 -e "xpack.security.enabled=false" -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.5.4
docker start es6-fa
