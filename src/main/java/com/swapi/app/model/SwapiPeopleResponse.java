package com.swapi.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SwapiPeopleResponse {
    @JsonProperty("total_records")
    private int totalRecords;
    @JsonProperty("total_pages")
    private int totalPages;
    private List<PersonSummary> results;
}
