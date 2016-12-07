# Introduction to Service Design and Engineering (fall 2016) - Assignment 3

This repository contains the solution for the third assignment of the course Introduction to Service Design and Engineering from the University of Trento (fall semester, 2016).

The following topics / technologies are covered in this lab assignment:
- SOAP
- Java
- XML
- JAX-WS
- Java Persistence API (JPA)

## Getting started

This project is composed of two parts (client and server) located in different Github repositories. This repository contains only the Java client app.

The code was written using IntelliJ IDEA 2016.2.5 and the dependencies are managed with Maven.

The stub classes were generated using wsimport.

## The client app

Run the execute.client target inside the [ant-client.xml](ant-client.xml) file (ant execute.client). This will compile all the necessary Java code and provide the test results. 

After the tests have been executed, the output will be stored by default inside the "log" folder.

The location of the different env URLs and the log file can be specified inside the [src/main/resources/project.properties](src/main/resources/project.properties) file.

Make sure you have set up the corresponding environment variable (env) to "heroku" or "local", depending on the server you want to use.