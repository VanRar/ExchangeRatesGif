package ru.alfabank.exchangeratesgif.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRatesDto {
    private HashMap<String, Double> rates;
}
