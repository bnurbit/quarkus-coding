# Docker

### Start a DB container
docker run --name quarkus-db -e MYSQL_ROOT_PASSWORD=root -p 3310:3306 -d mysql

### Accessing the DB container and creating a database
docker exec -ti <container_id> bash
mysql -uroot -proot
create database <database_name>;
use <database_name>
create table <table_name>([table_args])