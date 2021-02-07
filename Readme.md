# Wiremock Example

### Swagger Docs

http://editor.swagger.io/
http://localhost:7443/__admin/docs
http://localhost:7443/__admin/swagger-ui/
http://localhost:7443/__admin/docs/swagger

### curl commands
```shell script
curl http://localhost:7443/__admin/mappings -X POST --data '@./mappings/PriorityExample.json'

```
### Priority

Run the JUnit to create stubmappings

Run the docker image to serve it as a container

```
docker build . -t wiremock-example:latest
docker run --name wiremock-emaple -p 7443:7443  --cpuset-cpus=1 --memory=4g --rm -d wiremock-example:latest
```

To verify the docker, you can use test container 

### Verfication

Extra calls?
Unwanted Calls
```java
        //Atleast one time
        verify(postRequestedFor(urlPathEqualTo("/payments"))
                .withRequestBody(equalToJson("{" +
                        "  \"creditCardNumber\": \"1234-1234-1234-1234\"," +
                        "  \"creditCardExpiry\": \"2018-02-01\"," +
                        "  \"amount\": 20.55" +
                        "}")));
```

```java
        //exactly 3 times
        verify(3, postRequestedFor(urlPathEqualTo("/payments"))
                .withRequestBody(equalToJson("{" +
                        "  \"creditCardNumber\": \"1234-1234-1234-1234\"," +
                        "  \"creditCardExpiry\": \"2018-02-01\"," +
                        "  \"amount\": 20.55" +
                        "}")));
```
##### Request Journal

Reset

#### Created project using maven command line
```
 mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-java-benchmark-archetype \
          -DgroupId=com.arunapi \
          -DartifactId=wiremock-example\
          -Dversion=0.0.1
```
##### windows command line
```
 mvn archetype:generate ^
          -DinteractiveMode=false ^
          -DarchetypeGroupId=org.openjdk.jmh ^
          -DarchetypeArtifactId=jmh-java-benchmark-archetype ^
          -DgroupId=com.arunapi ^
          -DartifactId=wiremock-example^
          -Dversion=0.0.1

```





