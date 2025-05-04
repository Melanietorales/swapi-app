package com.swapi.app.model;

import lombok.Data;

import java.util.List;

@Data
public class SwapiNameSearchResponse {
    private List<SwapiSearchResult> result;
}
