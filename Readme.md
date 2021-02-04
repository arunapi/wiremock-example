# Wiremock Example

### Priority

Run the JUnit to create stubmappings

Run the docker image to serve it as a container

```
docker build . -t wiremock-example:latest
docker run --name wiremock-emaple -p 7443:7443  --cpuset-cpus=1 --memory=4g --rm -d wiremock-example:latest
```

To verify the docker, you can use test container 


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





