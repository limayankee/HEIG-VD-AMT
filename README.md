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

You can the test the application by accessing [http://localhost:9090/app/](http://localhost:9090/app/).

### Usage
The application offers several pages:
- The **index** of the application is a landing page offering two options: login and register.
- The **login** page gives the ability to log on the site. The default user is ***admin*** with the password ***adminpass***. If you access this page while already connected, you can log in with another account.
- The **register** page gives the ability to create a new account. You will then be redirected to the login page. You can also access this page while being already connected.
- The **admin** page shows a table containing all the users created. The interface does not allow to control the users directly.
- The **error** page displays details about an error that occured.

### Test
A postman script is located at *test/AMT.postman_collection.json*. You will also need to add the postman environment *AMT.postman_environment.json*.
The script should be used with a fresh running image of the application (containing only the preset database). 
Simply import the scripts and run them in Postman application.

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


