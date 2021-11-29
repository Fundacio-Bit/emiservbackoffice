#!/bin/bash

env mvn -DgroupId=es.caib.emiservbackoffice -DartifactId=* versions:set -DnewVersion=$@  

