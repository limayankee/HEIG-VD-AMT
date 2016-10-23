HEIG-VD-AMT
==========

First laboratory of AMT course at HEIG-VD.

-------------

Authors:
- [**Julien Leroy**](https://github.com/limayankee)
- [**Loïc Serafin**](https://github.com/pikkle)

### Installation
This has been tested on macOS, Linux and Windows.
Please clean your Docker environment before building the docker containers, for example using `docker rmi $(docker images -q)`

To build and run the application, simply use the following commands in terminal (with Docker running in background)

`cd topology-amt`

`docker-compose up`

This should run three docker images called *topologyamt_mysql_1*, *topologyamt_phpmyadmin_1* and *topologyamt_wildfly_1* running the different services needed for the application.

### List of used ports

- 9090 Wildfly
- 9999 Wildfly admin console
- 3306 Mysql
- 6060 PhpMyAdmin

### API REST
Here is a list of all the requests accessible with the API REST:

#### GET Requests
- **/api/user** : Gives the list of all users registrated
- **/api/user/$id** : Gives the user identified with the given id

#### POST Requests
- **/api/user** : To store a new user. Parameters:
  - username (*mandatory*)
  - password (*mandatory*)
  - firstname (*mandatory*)
  - lastname (*mandatory*)
- **/api/user/$id** : To edit a given user identified with the given id. Parameters:
  - password
  - firstname
  - lastname

#### DELETE Requests
- **/api/user/$id** : Deletes the user identified with the given id.


