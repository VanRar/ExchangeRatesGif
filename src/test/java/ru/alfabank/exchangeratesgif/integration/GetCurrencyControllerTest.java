package ru.alfabank.exchangeratesgif.integration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GetCurrencyControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static final String VALID_REQUEST = "/rates/RUB";
    private static final String INDEX_VIEW_NAME = "index";
    private static final String MODEL_ATTRIBUTE = "gif";
    private static final String REGEX = "https://giphy.com/embed/" + "(\\w*)";

    private static final String BAD_REQUEST = "/";
    private final String MESSAGE_BAD_REQUEST = "Invalid request entered, sample request: rates/RUB";

    @Test
    void getCurrencyGiphyWhenValidRequest() throws Exception {
        mockMvc.perform(get(VALID_REQUEST))
                .andExpect(view().name(INDEX_VIEW_NAME))
                .andExpect(model().attribute(MODEL_ATTRIBUTE, Matchers.matchesRegex(REGEX)));
    }

    @Test
    void getCurrencyGiphyWhenBadRequest() throws Exception {
        mockMvc.perform(get(BAD_REQUEST))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(MESSAGE_BAD_REQUEST));
    }
}
