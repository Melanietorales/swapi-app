package com.swapi.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SwapiStarshipByIdResponseDto {
    private StarshipSearchResultDto result;
}
