#!/bin/sh

DIST_DIR='milk-dist'
PROJECT_NAME='milk-deploy'
WAR_OUTPUT='milk'

mkdir $DIST_DIR && cd $DIST_DIR

# get and unpack the latest revision from github
TAR_FILE=milk_`date +%Y%m%d-%H%M`.tar.gz
wget -O $TAR_FILE --no-check-certificate https://github.com/mediaman-technology/milk/tarball/master
tar xfz $TAR_FILE

# identify and rename the unpacked directory to a easier-to-handle name
TAR_DIR=`find .  -type d -name "mediaman-technology*" | sed s:\.\/::`
mv $TAR_DIR $PROJECT_NAME

# now actually build the war file
play war $PROJECT_NAME -o $WAR_OUTPUT --zip

