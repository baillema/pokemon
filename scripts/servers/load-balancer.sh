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

# Standalone mode + deployment
cp $WILDFLY_HOME/docs/examples/configs/standalone-load-balancer.xml $WILDFLY_HOME/standalone/configuration/
cp $DEPLOY_FILE $WILDFLY_HOME/standalone/deployments

# Start the load balancer with the load-balancer profile
$WILDFLY_HOME/bin/standalone.sh -c standalone-load-balancer.xml -b $MY_IP -bprivate $MY_IP -bmanagement $MY_IP
