This application implements a simple api using maven,jersey,spring , jpa, hibernate and h2 database.
data.sql includes initial data for the h2 database .

You can access the h2 database in http://localhost:8080/h2/
database url : jdbc:h2:mem:app_db
username : sa
pasword :

************BUILD/RUN APPLICATION************

In order to build the application you just run "mvn clean install"


For runnuning the application , I used a tcomat server,you can run it by just  run the following command in cmd 

"java -jar FULLPATH\restApi\target\restApi-0.0.1-SNAPSHOT.jar"


************TEST WEB SERVICES************

I used Postman to test the two functionalities of save and retrieve a user


Save user : http://localhost:8080/saveUser

Post request : { "id": 6, 
"first_name": "John",
"last_name": "Collins",
"email": "jcollins9@testmail.gr",
"gender": "Male", 
"ip_address": "247.11.125.85" }

Answer : 201 created 



Retrieve user :  http://localhost:8080/getUser?email=jcollins9@testmail.gr or http://localhost:8080/getUser?ip_address=247.11.125.85

Answer : {
    "id": 3,
    "email": "jcollins9@testmail.gr",
    "gender": "Male",
    "first_name": "John",
    "last_name": "Collins",
    "ip_address": "247.11.125.85"
}


************