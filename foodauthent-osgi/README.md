## java

Java projects and sources

## Required Docker containers:

### ApacheDS
#### create (only required once)
docker create --name apacheds-fa -p 10389:10389 docker-registry.foodauthent.net/apacheds:latest

#### start
docker start apacheds-fa

#### stop
docker stop apacheds-fa

### Elasticsearch
#### create (only required once)
docker create --name es6-fa -p 9200:9200 -p 9300:9300 -e "xpack.security.enabled=false" -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.5.4

#### start
docker start es6-fa

#### stop
docker stop es6-fa