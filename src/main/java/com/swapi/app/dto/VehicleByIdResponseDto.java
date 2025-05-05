package com.swapi.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleByIdResponseDto {
    private VehicleListResultsDto result;

}
