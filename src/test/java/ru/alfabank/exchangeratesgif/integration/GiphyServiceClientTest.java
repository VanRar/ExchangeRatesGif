package ru.alfabank.exchangeratesgif.integration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.alfabank.exchangeratesgif.dto.GiphyDataDto;
import ru.alfabank.exchangeratesgif.feignclient.GiphyServiceClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GiphyServiceClientTest {
    @Autowired
    GiphyServiceClient sut;

    private static final String API_KEY = "a42UmGhaoKtf7QdQOm7hYTH9g7b66w4L";
    private static final String TAG = "ANYTHING";
    public static final String REGEX = "https://giphy.com/embed/" + "(\\w*)";

    @Test
    void getGiphyJson() {
        GiphyDataDto giphyDataDto = sut.getGiphyJson(API_KEY, TAG);
        String giphyUrl = giphyDataDto.getData().getEmbed_url();

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(giphyUrl);

        assertTrue(matcher.matches());
    }
}
