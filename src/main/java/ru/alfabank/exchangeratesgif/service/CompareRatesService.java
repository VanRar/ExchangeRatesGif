package ru.alfabank.exchangeratesgif.service;


import org.springframework.stereotype.Service;
import ru.alfabank.exchangeratesgif.dto.OpenExchangeRatesProperties;
import ru.alfabank.exchangeratesgif.feignclient.CurrencyExchangeServiceClient;
import ru.alfabank.exchangeratesgif.util.DataUtil;

@Service
public class CompareRatesService {
    private static final String MESSAGE_ERROR_GET_CURRENCY =
            "Курсы валют недоступны. Проверьте правильность свойства 'app_id'";

    private final OpenExchangeRatesProperties openExchangeRatesProperties;
    private final CurrencyExchangeServiceClient cesClient;
    private final String APP_ID;

    public CompareRatesService(OpenExchangeRatesProperties openExchangeRatesProperties, CurrencyExchangeServiceClient cesClient) {
        this.openExchangeRatesProperties = openExchangeRatesProperties;
        this.cesClient = cesClient;
        this.APP_ID = openExchangeRatesProperties.getApiKey();
    }

    public int compareRates(String currency) {
        double todayCurrencyRate = getCurrencyRate(currency, DataUtil.today());
        double yesterdayCurrencyRate = getCurrencyRate(currency, DataUtil.yesterday());
        return Double.compare(todayCurrencyRate, yesterdayCurrencyRate);
    }

    private double getCurrencyRate(String currency, String date) {
        double currencyRate;

        try {
            currencyRate = cesClient.getHistoricalCurrencyJson(date, APP_ID).getRates().get(currency);
        } catch (Exception e) {
            throw new RuntimeException(MESSAGE_ERROR_GET_CURRENCY + e.getMessage());
        }
        return currencyRate;
    }
}
