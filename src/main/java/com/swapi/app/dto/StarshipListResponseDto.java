package com.swapi.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StarshipListResponseDto {
    @JsonProperty(value = "total_records")
    private Integer totalRecords;
    @JsonProperty(value = "total_pages")
    private Integer totalPages;
    private String previous;
    private String next;
    List<SwapiStarshipPropertiesDto> results;

}
