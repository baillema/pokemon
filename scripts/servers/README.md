# Servers

## load-balancer

Script launching a load-balancer using the ``standalone-load-balancer.xml`` introduced in Wildfly 10.1 installation.
This script should be put in the home folder of the load-balancer VM.

## node-worker

Script launching a node-worker using the ``standalone-ha.xml``. This script should be put in the home folder of each
VMs.

## Notes

- We need to pull and compile the project on every VMs. Should be automated Soon™.
- To change the deployed file, change ``DEPLOY_FILE`` in all scripts.
- All the IPs should be put in /etc/hosts