#!/usr/bin/env bash

# ==== Resource Group ====
export RESOURCE_GROUP=rg-petclinic # customize this
export LOCATION=eastus # customize this

# ==== Environment and App Instances ====
export CONTAINER_APP_ENVIRONMENT=petclinic-env # customize this
export CONFIG_SERVER_COMPONENT=configserver
export ADMIN_SERVER_COMPONENT=admin
export EUREKA_SERVER_COMPONENT=eureka
export CONFIG_SERVER_URI=https://github.com/spring-petclinic/spring-petclinic-microservices-config.git
export CUSTOMERS_SERVICE=customers-service
export VETS_SERVICE=vets-service
export VISITS_SERVICE=visits-service
export API_GATEWAY=api-gateway

# ==== MYSQL INFO ====
export MYSQL_SERVER_NAME=mysql-petclinic-pwl # customize this
export MYSQL_SERVER_FULL_NAME=${MYSQL_SERVER_NAME}.mysql.database.azure.com
export MYSQL_SERVER_ADMIN_NAME=azureuser # customize this
export MYSQL_SERVER_ADMIN_LOGIN_NAME=${MYSQL_SERVER_ADMIN_NAME}\@${MYSQL_SERVER_NAME}
export MYSQL_SERVER_ADMIN_PASSWORD=SuperS3cr3t # customize this
export MYSQL_DATABASE_NAME=petclinic
export MYSQL_IDENTITY=mysql-identity

