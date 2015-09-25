# Dropwizard Postgresql Example
A basic example of how to use a postgresql database in Dropwizard. 
This example was written for Dropwizard 0.8.4.

## Running the Project

In order to run it make sure you provide the arguments "server DropWizardPostgres.yml".

It should now be running on http://localhost:8080

You'll need to add some entries to your database, here's an example table:
 ```sql
 CREATE TABLE people(personid SERIAL PRIMARY KEY, firstName TEXT, surname TEXT);
```
In order to view an entry head to 'http://localhost:8080/people/ID', where ID is the 'personid' of one of your entries.


## How it works

- JDBI and Postgresql are included as dependencies in the POM (pom.xml)
- The database credentials are set in the YAML config file (DropWizardPostgres.yml)
- Data is contained in a POJO (Person.java)
- SQL queries for the data are in a DAO (PersonDAO.java)
- In order to handle queries which may return multiple Person objects e.g. `SELECT firstName FROM People WHERE surname = "Gough"` a Mapper (PersonMapper.java) is used.
- Person resource handles requests on the '/people' path and contains the PersonDAO
