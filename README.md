# Expense Tracking Project - Initialization and Startup

## DBMS Connection

The program uses JDBC to make a connection to the database that stores
the user and invoice information.  It uses the values of the following
environment variables to provide login information.

db_user
db_password
db_url

These should be set in the run configuration of the server (probably Tomcat).
The db_url value shoud be a valid JDBC location, for example:

jdbc:postgresql://127.0.0.1:5432/postgres

## DBMS Initialization

When the app first starts, it creates the tables needed to hold the
data.

For the first login, you don't need to enter a user ID or password -
the app logs you in as the machine generated administrator - ID admin,
password admin.  From there, you can enter employee, manager, and
administrator users.
