# spring-boot-3-oauth2
A POC that implements all the new spring boot 3 features for oauth2
You will find 3 modules, one per oauth2 roles

## Resource Server
### how to test it
Run the authorization server as described below and get a token. Then use it with the following curl command  
curl -H "Authorization: Bearer $TOKEN" localhost:8090/message  
you should see the following result  
secret message