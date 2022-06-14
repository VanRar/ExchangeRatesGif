package ru.alfabank.exchangeratesgif.integration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.alfabank.exchangeratesgif.service.GiphyLookerService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GiphyLookerServiceTest {
    @Autowired
    GiphyLookerService sut;

    private static final String TAG = "ANYTHING";
    public static final String REGEX = "https://giphy.com/embed/" + "(\\w*)";

    @Test
    void searchGiphyMethodTest() {
        String giphyLookerServiceResult = sut.searchGiphy(TAG);
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(giphyLookerServiceResult);
        assertTrue(matcher.matches());
    }
}
