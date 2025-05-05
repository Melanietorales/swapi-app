package com.swapi.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwapiStarshipByIdResponse {
    private StarshipSearchResult result;
}
