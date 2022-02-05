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

