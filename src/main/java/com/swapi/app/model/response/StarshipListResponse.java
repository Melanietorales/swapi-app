package com.swapi.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarshipListResponse {
    @JsonProperty(value = "total_records")
    private Integer totalRecords;
    @JsonProperty(value = "total_pages")
    private Integer totalPages;
    private String previous;
    private String next;
    List<StarshipProperties> results;

}
