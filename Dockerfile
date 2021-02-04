FROM openjdk:14-jdk-alpine

WORKDIR /wiremock

RUN wget https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-standalone/2.27.2/wiremock-standalone-2.27.2.jar

COPY mappings ./mappings

CMD ["java", "-jar", "wiremock-standalone-2.27.2.jar", "--port", "7443"]
#CMD ["java", "-jar", "wiremock-standalone-2.27.2.jar", "--disable-http", "--https-port", "7443", "--https-truststore", "/etc/wiremock/certs/server_truststore.p12", "--truststore-password", "secret", "--https-keystore", "/etc/wiremock/certs/server_keystore.p12", "--keystore-password", "secret", "--keystore-type", "PKCS12", "--key-manager-password", "secret"]
# java -jar wiremock-standalone-2.27.2.jar --disable-http --https-port 7443 --https-truststore ~/git/cart-information/src/test/resources/certs/server_truststore.p12 --truststore-password secret --https-keystore ~/git/cart-information/src/test/resources/certs/server_keystore.p12 --keystore-password secret --keystore-type PKCS12
#java -jar wiremock-standalone-2.27.2.jar --disable-http --https-port 7443 --https-truststore ~/git/cart-information/src/test/resources/certs/server_truststore.p12 --truststore-password secret --https-keystore ~/git/cart-information/src/test/resources/certs/server_keystore.p12 --keystore-password secret --keystore-type PKCS12 --key-manager-password secret

