# Docker

## Start a DB container, access it and create a database

### Mysql
docker run --name quarkus-db -e MYSQL_ROOT_PASSWORD=root -p 3310:3306 -d mysql
docker exec -ti <container_id> bash
mysql -uroot -proot
create database <database_name>;
use <database_name>;
create table <table_name>([table_args]);

### Postgres
docker run --name quarkus-db -e POSTGRES_PASSWORD=root -p 5432:5432 -d postgres
docker exec -ti <container_id> bash
psql -h localhost -p 5432 -U postgres -W
create database <database_name>;
\connect <database_name>;

### Elasticsearch
docker run -it --rm=true --name quarkus-elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.15.0

## docker useful commands
docker inspect [OPTIONS] NAME|ID [NAME|ID...] - Return low-level information on Docker objects