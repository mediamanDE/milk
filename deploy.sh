#!/bin/sh

PROJECT_NAME='milk-deploy'
WAR_OUTPUT='milk-war'

TAR_FILE=milk_`date +%Y%m%d-%H%M`.tar.gz
wget -O $TAR_FILE --no-check-certificate https://github.com/mediaman-technology/milk/tarball/master
tar xfz $TAR_FILE
TAR_DIR=`find .  -type d -name "mediaman-technology*" | sed s:\.\/::`
mv $TAR_DIR $PROJECT_NAME

play war $PROJECT_NAME -o $WAR_OUTPUT --zip

