package com.swapi.app.model.response;

import lombok.Data;

import java.util.List;

@Data
public class VehicleSearchResult {
    private List<VehicleListResults> result;
}
