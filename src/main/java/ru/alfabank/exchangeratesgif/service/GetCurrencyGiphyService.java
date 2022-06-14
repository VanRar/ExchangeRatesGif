package ru.alfabank.exchangeratesgif.service;


import org.springframework.stereotype.Service;
import ru.alfabank.exchangeratesgif.dto.DevelopersGiphyProperties;


@Service
public class GetCurrencyGiphyService {
    private final CompareRatesService compareRatesService;
    private final GiphyLookerService giphyLookerService;
    private final DevelopersGiphyProperties developersGiphyProperties;

    public GetCurrencyGiphyService(CompareRatesService compareRatesService, GiphyLookerService giphyLookerService, DevelopersGiphyProperties developersGiphyProperties) {
        this.compareRatesService = compareRatesService;
        this.giphyLookerService = giphyLookerService;
        this.developersGiphyProperties = developersGiphyProperties;
    }

    public String getCurrencyGiphy(String currency) {
        String giphyTag = "";

        switch (compareRatesService.compareRates(currency)) {
            case 1:
                giphyTag = developersGiphyProperties.getGiphyTagPositive();
                break;
            case -1:
                giphyTag = developersGiphyProperties.getGiphyTagNegative();
                break;
            case 0:
                giphyTag = developersGiphyProperties.getGiphyTagNeutral();
                break;
        }

        return giphyLookerService.searchGiphy(giphyTag);
    }
}
