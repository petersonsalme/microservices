# Microservices Project

Project created based on the book <b>Microservices for Java Developers <i>by Rafael Benevides & Christian Posta</i></b>.

### node_backend

Microservice that exposes the API: <code>GET /api/backend?greeting={greeting}</code>.</br>
This API should receive query Param greeting and use its value, together server IP and current time in milliseconds, to compose a JSON object and return it on response.

### hello_springboot

Microservice that exposes the API: <code>GET /api/greeting</code>.</br>
This API should load value <code>greeting.saying</code> from microservice's <code>application.properties</code> and use it to invoke <b>node_backend</b>'s API.</br>
</br>
Created using <code>Spring Boot 2.3.3.RELEASE</code>. 

### hello_microprofile

Microservice that exposes the API: <code>GET /api/greeting</code>.</br>
This API should load value <code>greeting.saying</code> from microservice's <code>microprofile-config.properties</code> and use it to invoke <b>node_backend</b>'s API.</br>
</br>
Created using <code>MicroProfile/Thorntail 2.7.0.Final</code>. 

### api_gateway

API Gateway Microservice that exposes API: <code>GET /api/gateway</code>.<br>
When called, this API should dispatch, parallelally, one request for each microservices: hello_springboot and hello_microprofile.
Both responses should be accumulate in an ArrayList, the response for this API.<br>
<br>
Created using <code>Spring Boot 2.3.3.RELEASE</code> and <code>Apache Camel 3.4.3</code>.
