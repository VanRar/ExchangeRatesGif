package ru.alfabank.exchangeratesgif.unit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.alfabank.exchangeratesgif.dto.CurrencyRatesDto;
import ru.alfabank.exchangeratesgif.feignclient.CurrencyExchangeServiceClient;
import ru.alfabank.exchangeratesgif.service.CompareRatesService;
import ru.alfabank.exchangeratesgif.util.DataUtil;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompareRatesServiceTest {
    @MockBean(name = "cesClient")
    CurrencyExchangeServiceClient cesClient;

    @Autowired
    CompareRatesService sut;

    private static final String API_KEY = "33f8c48918f54b44bf8666aa51d92c5a";
    private static final String CURRENCY = "USD";

    private static final double CURRENCY_VALUE_BIGGER = 68.0;
    private static final double CURRENCY_VALUE_LOWER = 67.0;

    private static final String TODAY_DATE = DataUtil.today();
    private static final String YESTERDAY_DATE = DataUtil.yesterday();


    @Test
    public void compareRatesWhenTodayCurrencyValueBigger() {
        // given
        CurrencyRatesDto currencyRatesDtoToday = getCurrencyRatesDto(CURRENCY_VALUE_BIGGER);
        CurrencyRatesDto currencyRatesDtoYesterday = getCurrencyRatesDto(CURRENCY_VALUE_LOWER);

        Mockito.when(cesClient.getHistoricalCurrencyJson(TODAY_DATE, API_KEY)).thenReturn(currencyRatesDtoToday);
        Mockito.when(cesClient.getHistoricalCurrencyJson(YESTERDAY_DATE, API_KEY)).thenReturn(currencyRatesDtoYesterday);

        int compareRatesExpected = 1;

        int compareRatesResult = sut.compareRates(CURRENCY);

        assertEquals(compareRatesExpected, compareRatesResult);
    }


    @Test
    public void compareRatesWhenYesterdayCurrencyValueBigger() {
        // given
        CurrencyRatesDto currencyRatesDtoToday = getCurrencyRatesDto(CURRENCY_VALUE_LOWER);
        CurrencyRatesDto currencyRatesDtoYesterday = getCurrencyRatesDto(CURRENCY_VALUE_BIGGER);

        Mockito.when(cesClient.getHistoricalCurrencyJson(TODAY_DATE, API_KEY)).thenReturn(currencyRatesDtoToday);
        Mockito.when(cesClient.getHistoricalCurrencyJson(YESTERDAY_DATE, API_KEY)).thenReturn(currencyRatesDtoYesterday);

        int compareRatesExpected = -1;

        int compareRatesResult = sut.compareRates(CURRENCY);

        assertEquals(compareRatesExpected, compareRatesResult);
    }

    @Test
    public void compareRatesWhenCurrencyValuesEquals() {
        // given
        CurrencyRatesDto currencyRatesDtoToday = getCurrencyRatesDto(CURRENCY_VALUE_LOWER);
        CurrencyRatesDto currencyRatesDtoYesterday = getCurrencyRatesDto(CURRENCY_VALUE_LOWER);

        Mockito.when(cesClient.getHistoricalCurrencyJson(TODAY_DATE, API_KEY)).thenReturn(currencyRatesDtoToday);
        Mockito.when(cesClient.getHistoricalCurrencyJson(YESTERDAY_DATE, API_KEY)).thenReturn(currencyRatesDtoYesterday);

        int compareRatesExpected = 0;

        int compareRatesResult = sut.compareRates(CURRENCY);

        assertEquals(compareRatesExpected, compareRatesResult);
    }

    private static CurrencyRatesDto getCurrencyRatesDto(double currencyValue) {
        HashMap<String, Double> ratesMap = new HashMap<>();
        ratesMap.put(CURRENCY, currencyValue);

        return CurrencyRatesDto.builder()
                .rates(ratesMap)
                .build();
    }
}
