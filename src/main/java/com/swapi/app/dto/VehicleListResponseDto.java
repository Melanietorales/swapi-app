package com.swapi.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleListResponseDto {
    private Integer totalRecords;
    private Integer totalPages;
    private String previous;
    private String next;
    private List<VehicleListPropertiesDto> results;
}
