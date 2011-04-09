#!/bin/sh

DIST_DIR='milk-dist'
WAR_OUTPUT='milk'

rm -r $DIST_DIR
mkdir $DIST_DIR 
cp -r app conf lib public $DIST_DIR


# now actually build the war file
play war $DIST_DIR -o $WAR_OUTPUT --zip

