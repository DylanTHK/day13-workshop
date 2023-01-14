# day13-workshop
Day 13 Workshop Spring Validation

## Objective
The objective of this workshop is to write a simple address book. The information from the address book will be saved in a local filesystem as text file using Java IO package.

## Running code
mvn spring-boot:run -Dspring-boot.run.arguments="--dataDir=data"

AddressBookApplication.java
1. take in valid arguments
2. check --dataDir is present and not null

Contact.java
1. Validation for input (WS requirements) - Task 2
2. Getters and setters for class members
Define constructors
Method to calculate age
Method to generate random id

AppController.java
create form page 
define getmapping method to generate form page
postmapping to send info to /contact


TODO
