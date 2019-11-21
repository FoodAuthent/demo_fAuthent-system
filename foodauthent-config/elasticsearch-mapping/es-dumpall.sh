#!/bin/bash
IN="http://10.10.111.20:9200"
indices=$(curl -s -XGET ${IN}/_cat/indices?h=i)
for index in $indices
do
 docker run --rm -ti -v $(pwd)/data:/tmp taskrabbit/elasticsearch-dump \
  --input=${IN}/${index} \
  --output=/tmp/${index}_mapping.json \
  --type=mapping
 docker run --rm -ti -v $(pwd)/data:/tmp taskrabbit/elasticsearch-dump \
  --input=${IN}/${index} \
  --output=/tmp/${index}_data.json \
  --type=data
done
