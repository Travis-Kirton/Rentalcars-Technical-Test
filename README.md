# Rentalcars-Technical-Test
Rentalcars Technical Test (Console App + REST Service)


### Getting Started

To run the both tasks (part 1 + part 2) you'll need the following:
* Java (1.8)
* Maven (I used 3.3.9)


### Part 1

Part 1 is a Java console application. To run, ensure within root directory and use the following:

```  
java -jar rentalcars_part.jar
 ```

This will output all parts, including
* Cars Listed (Ordered By Price - Ascending)
* Cars Listed with Specifications
* Cars Listed (Ordered By Rating - Descending)
* Cars Listed (Ordered By Score - Descending)


### Part 2

Part 2 is a RESTful service that allows a JSON output of results when calling a specific end-point.

To run this section, navigate into the 'rest-service' directory and run the following:
```
mvn clean install 
mvn spring-boot:run
```

Or within the root directory containing JARs

```
java -jar rest-service-0.0.1-SNAPSHOT.jar
```

<sub>(tests will be run during this process as well)</sub>

this will launch the web-service on port 8080. Navigate to [http://localhost:8080/service/vehicles/](http://localhost:8080/service/vehicles/)

You can then append the following to get specific results

|URL End-point|Description|
|---|---|
|listCarsByPriceAsc|Will output a JSON result of Cars ordered by price|
|listCarsSpecification|Will output a JSON result of Cars with specifications|
|listCarsHighestRatedDesc|Will output a JSON result of Cars ordered by Rating|
|listCarsScoredDesc|Will output a JSON result of Cars ordered by Sum of Rating & Score|

e.g. 
[http://localhost:8080/service/vehicles/listCarsByPriceAsc](http://localhost:8080/service/vehicles/listCarsByPriceAsc)


### Development Environment

* IDE = Eclipse Neon
* OS = Ubuntu 17.04
* Browsers Tested with = Chrome, Firefox, IE


### Languages/frameworks/dependencies

* Java 1.8
* Spring Boot Framework
* Maven
* Jackson (JSON Parsing)
* JUnit 1.4 for testing
* Spring Boot Mvc Mocking for testing







