package com.swapi.app.model;

import lombok.Data;

import java.util.List;

@Data
public class SwapiFilmListResponse {
    private List<SwapiFilmListResults> result;
}
