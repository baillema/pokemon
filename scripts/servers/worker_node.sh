#!/bin/bash

# Clean up
pgrep -d " " -f "wildfly" | xargs kill;

# Config variables
MY_IP=$(ip route get 8.8.8.8 | awk '{print $NF; exit}')
WILDFLY_ARCHIVE=~/wildfly-10.1.0.Final.tar.gz
WILDFLY_HOME=~/wildfly
DEPLOY_FILE=~/test_loader/target/test_load_balancer-1.0-SNAPSHOT.war

# Fresh install
rm -rf $WILDFLY_HOME
tar -zxvf $WILDFLY_ARCHIVE
mv wildfly-10.1.0.Final $WILDFLY_HOME

# Deployment
cp $DEPLOY_FILE $WILDFLY_HOME/standalone/deployments

# Start the node worker with the standalone-ha profile
$WILDFLY_HOME/bin/standalone.sh -c standalone-ha.xml -b $MY_IP -bprivate $MY_IP -bmanagement $MY_IP
