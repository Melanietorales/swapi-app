package com.swapi.app.model.response;

import lombok.Data;

import java.util.List;

@Data
public class PeopleNameSearchResponse {
    private List<PeopleSearchResult> result;
}
