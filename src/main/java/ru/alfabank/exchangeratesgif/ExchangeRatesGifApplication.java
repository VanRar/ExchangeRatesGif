package ru.alfabank.exchangeratesgif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ExchangeRatesGifApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeRatesGifApplication.class, args);
    }

}
