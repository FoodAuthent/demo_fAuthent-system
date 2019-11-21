#!/bin/bash
INDEX_POSTFIX=-20191119
ES_HOST="10.10.111.20:9200"
files=$(ls -1a *.json)
for f in $files; do
 index=$(echo $f | sed 's/\.json//g')
 index=${index}${INDEX_POSTFIX}
 echo $index
 curl -XPUT -H 'Content-Type: application/json' ${ES_HOST}/${index} -d @${f}
done
