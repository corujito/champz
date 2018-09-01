#!/bin/sh

kubectl delete -f champz-web-service.yaml
kubectl delete -f champz-web-dep.yaml
kubectl delete -f champz-web-postgresdb-service.yaml
kubectl delete -f champz-web-postgresdb-dep.yaml

kubectl delete -f champz-restservice-service.yaml
kubectl delete -f champz-restservice-dep.yaml
kubectl delete -f champz-restservice-mongodb-service.yaml
kubectl delete -f champz-restservice-mongodb-dep.yaml

#kubectl create -f champz-restservice-mongodb-dep.yaml
#kubectl create -f champz-restservice-mongodb-service.yaml
#kubectl create -f champz-restservice-dep.yaml
#kubectl create -f champz-restservice-service.yaml

#kubectl create -f champz-web-postgresdb-dep.yaml
#kubectl create -f champz-web-postgresdb-service.yaml
#kubectl create -f champz-web-dep.yaml
#kubectl create -f champz-web-service.yaml
