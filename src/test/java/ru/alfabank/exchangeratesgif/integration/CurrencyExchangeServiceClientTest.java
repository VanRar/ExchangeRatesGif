package ru.alfabank.exchangeratesgif.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.alfabank.exchangeratesgif.feignclient.CurrencyExchangeServiceClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CurrencyExchangeServiceClientTest {
    private static final String API_KEY = "33f8c48918f54b44bf8666aa51d92c5a";
    private static final String DATE = "2022-06-13";
    private static final String CURRENCY = "RUB";
    private static final double EXPECTED_CURRENCY_VALUE = 57.749998;

    @Autowired
    CurrencyExchangeServiceClient sut;

    @Test
    public void getHistoricalCurrencyJson() {
        double resultCurrencyValue = sut.getHistoricalCurrencyJson(DATE, API_KEY)
                .getRates().get(CURRENCY);
        assertEquals(EXPECTED_CURRENCY_VALUE, resultCurrencyValue);
    }
}
