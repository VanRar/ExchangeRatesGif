FROM openjdk:17.0.2-oraclelinux8

ENV PORT 8080
EXPOSE $PORT

COPY build/libs/ExchangeRatesGif-0.0.1-SNAPSHOT.jar ExchangeRatesGif.jar
CMD ["java", "-jar", "/ExchangeRatesGif.jar"]