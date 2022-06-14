package ru.alfabank.exchangeratesgif.dto;


import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class DevelopersGiphyProperties {
    @NotBlank(message = "Заполните api url")
    private String apiUrl;
    @NotBlank(message = "Заполните api key name")
    private String apiKeyName;
    @NotBlank(message = "Заполните api key")
    private String apiKey;
    @NotBlank(message = "Заполните giphy tag positive")
    private String giphyTagPositive;
    @NotBlank(message = "Заполните giphy tag negative")
    private String giphyTagNegative;
    @NotBlank(message = "Заполните giphy tag neutral")
    private String giphyTagNeutral;
}
