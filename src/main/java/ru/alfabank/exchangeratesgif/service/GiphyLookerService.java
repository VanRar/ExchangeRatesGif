package ru.alfabank.exchangeratesgif.service;


import org.springframework.stereotype.Service;
import ru.alfabank.exchangeratesgif.dto.DevelopersGiphyProperties;
import ru.alfabank.exchangeratesgif.feignclient.GiphyServiceClient;


@Service
public class GiphyLookerService {
    private static final String MESSAGE_ERROR_GET_GIPHY = "Гифки недоступны. Проверьте правильность свойств 'app_id', 'giphy_tag'";

    private final DevelopersGiphyProperties developersGiphyProperties;
    private final GiphyServiceClient gsClient;
    private final String API_KEY;

    public GiphyLookerService(DevelopersGiphyProperties developersGiphyProperties, GiphyServiceClient gsClient) {
        this.developersGiphyProperties = developersGiphyProperties;
        this.gsClient = gsClient;
        this.API_KEY = developersGiphyProperties.getApiKey();
    }

    public String searchGiphy(String giphyTag) {
        String giphyUrl;
        try {
            giphyUrl = gsClient.getGiphyJson(API_KEY, giphyTag).getData().getEmbed_url();
        } catch (Exception e) {
            throw new RuntimeException(MESSAGE_ERROR_GET_GIPHY + e.getMessage());
        }
        return giphyUrl;
    }
}
