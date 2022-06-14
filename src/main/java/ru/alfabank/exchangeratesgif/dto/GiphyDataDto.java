package ru.alfabank.exchangeratesgif.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiphyDataDto {
    private Data data;

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Data {
        private String embed_url;
    }
}
