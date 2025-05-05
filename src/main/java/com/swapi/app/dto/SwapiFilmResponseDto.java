package com.swapi.app.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SwapiFilmResponseDto {
    private List<SwapiFilmListResultsDto> result;

}
