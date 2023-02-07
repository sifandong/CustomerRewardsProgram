## Customer Rewards Program
This is a Spring Boot application that used to demostrate Web APIs for Chrter Assessment.

## Features
* CRUD operations for Customer and Transaction
* Retrieve customers' rewards data between two dates

## Dependencies
* Java 8
* Spring Boot 
* Maven

## Running
* clone this repository 
* run it using java -jar or open it in your IDE to execute the main method



```sql
CREATE DATABASE customerRewards;
use customerRewards;

DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `transaction`;

CREATE TABLE customer (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
);

CREATE TABLE transaction (
    id INT unsigned NOT NULL AUTO_INCREMENT,
    date VARCHAR(255);
    amount INT;
    rewards INT;
)
```