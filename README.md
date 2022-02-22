# go-sports-backend

#Sonar
First sonar must be run in docker, command below:
```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true 
-p 9000:9000 sonarqube:latest 
```

Run the command for submit our code for sonar 
```
mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=[Sonar token]
``` 
How pick sonar token, please see the tutorial [click here](https://www.decodingdevops.com/how-to-generate-sonarqube-authentication-token-api/)

OBS: It's need sonar server is up before execute this command

#Swagger UI
We can access swagger ui -> http://localhost:8080/swagger-ui.html

Reference: 

#Docker

docker run -p 8080:8080 -e FORUM_DATABASE_URL='jdbc:h2:mem:alura-forum' -e FORUM_DATABASE_USERNAME='sa' -e FORUM_DATABASE_PASSWORD='' -e FORUM_JWT_SECRET='123456' alura/forum

## Fun to deploy the app in Heroku cloud

1. It should create new application 
  ````
  heroku create go-sports-backend
  ````
2. Add the project for git from heroku
 ````
 heroku git:remote –a go-sports-backend
  ````
3. Login the keroku container
 ````
 heroku container:login
  ````
4. Push the container (Dockerfile file) to cloud
 ````
 heroku container:push web  
  ````
 ````
 heroku container:release web
  ````
4. Check the log from the application
 ````
   heroku logs --tail
 ````
5. Open the application
 ````
   heroku open
 ````

