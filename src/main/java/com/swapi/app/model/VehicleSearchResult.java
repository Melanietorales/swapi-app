package com.swapi.app.model;

import lombok.Data;

import java.util.List;

@Data
public class VehicleSearchResult {
    private List<VehicleListResults> result;
}
