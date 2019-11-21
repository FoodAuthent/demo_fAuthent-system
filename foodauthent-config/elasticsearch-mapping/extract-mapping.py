#!/usr/bin/python

import json
import sys

filename = sys.argv[1]
with open(filename) as json_file:
    data = json.load(json_file)
    mappings = data[filename.replace('.json', '')]['mappings']
    settings = data[filename.replace('.json', '')]['settings']
    if 'data' in mappings and 'properties' in mappings['data'] and 'prediction-map' in mappings['data']['properties']:
        del mappings['data']['properties']['prediction-map']
    print '{ "mappings" :',
    print json.dumps(mappings, indent=4)
    print '}'
