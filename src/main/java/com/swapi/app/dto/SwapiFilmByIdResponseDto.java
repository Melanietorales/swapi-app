package com.swapi.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SwapiFilmByIdResponseDto {
    private SwapiFilmListResultsDto result;

}
