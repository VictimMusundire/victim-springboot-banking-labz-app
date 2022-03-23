# Victim Musundire : Labz
#--------------------------------

# Running the Application
Edit the database connection configs in the application-dev.properties file to suit your MySQL 
database on local or server.
   
# You need to run
   -----------------
mvn clean 
mvn install
   

# The API Documentation

The documentation guid
http://localhost:8085/labz/swagger-ui.html

1.	Create Account (Account contains user details and Accounts associated with user)
2.	Cash Withdrawal
3.	Cash Deposit
4.	Funds Transfer (TODO)
5.	The transaction history logs are being written to the file log in the path defined in the application.properties and it can be altered.

*Note that to run on production you need to enable the prod profile and provide credentials

# Note
1.Perform more unit tests.
2.Adding currency related accounts.
3.Separate user entity to completely collect more customer details to know our customers
