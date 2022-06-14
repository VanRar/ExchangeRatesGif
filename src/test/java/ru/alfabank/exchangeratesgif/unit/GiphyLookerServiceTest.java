package ru.alfabank.exchangeratesgif.unit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.alfabank.exchangeratesgif.dto.GiphyDataDto;
import ru.alfabank.exchangeratesgif.feignclient.GiphyServiceClient;
import ru.alfabank.exchangeratesgif.service.GiphyLookerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GiphyLookerServiceTest {
    @MockBean(name = "gsClient")
    GiphyServiceClient gsClient;

    @Autowired
    GiphyLookerService sut;

    private static final String API_KEY = "a42UmGhaoKtf7QdQOm7hYTH9g7b66w4L";
    private static final String TAG = "ANYTHING";
    public static final String GIPHY_URL = "test giphy url";

    @Test
    public void searchGiphyShouldPassSuccess() {
        // given
        GiphyDataDto giphyDataDto = new GiphyDataDto();
        giphyDataDto.setData(giphyDataDto.new Data(GIPHY_URL));

        Mockito.when(gsClient.getGiphyJson(API_KEY,TAG)).thenReturn(giphyDataDto);

        String giphyDataResult = sut.searchGiphy(TAG);

        assertEquals(GIPHY_URL,giphyDataResult);
    }
}
