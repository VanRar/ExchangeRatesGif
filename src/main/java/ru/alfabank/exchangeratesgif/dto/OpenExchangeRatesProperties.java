package ru.alfabank.exchangeratesgif.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class OpenExchangeRatesProperties {
    @NotBlank(message = "заполните url")
    private String apiUrl;
    @NotBlank(message = "заполните api key name")
    private String apiKeyName;
    @NotBlank(message = "заполните api key")
    private String apiKey;
}
