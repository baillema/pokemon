#!/bin/bash

# Config variables
VM_IP=$(ip route get 8.8.8.8 | awk '{print $NF; exit}')
PROJECT_URL=https://github.com/Scra3/pokemon
PROJECT_HOME=~/pokemon
DEPLOY_FILE=$PROJECT_HOME/ecom/web/target/web.war

WILDFLY_ARCHIVE=~/wildfly-10.1.0.Final.tar.gz
WILDFLY_HOME=~/wildfly
WILDFLY_CONFIG=standalone.xml

# Clean up
pgrep -d " " -f "wildfly" | xargs kill;

# Clone the project if needed
if [ ! -d $PROJECT_HOME ]; then
  git clone $PROJECT_URL $PROJECT_HOME
fi

# Pull modifications and build the project
cd $PROJECT_HOME
git pull

# Uncomment and update the next line if you want to build a specific branch
# git checkout backend

mvn install
cd

# Fresh wildfly install
rm -rf $WILDFLY_HOME
tar -zxvf $WILDFLY_ARCHIVE
mv wildfly-10.1.0.Final $WILDFLY_HOME

# Deployment
cp $DEPLOY_FILE $WILDFLY_HOME/standalone/deployments/web.war

# Add an admin user
~/add-admin.sh

# Add the datasource
~/add-datasource.sh

# Start the load balancer with the load-balancer profile
$WILDFLY_HOME/bin/standalone.sh -c $WILDFLY_CONFIG -b $VM_IP -bprivate $VM_IP -bmanagement $VM_IP
