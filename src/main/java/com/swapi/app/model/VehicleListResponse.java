package com.swapi.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleListResponse {
    private Integer totalRecords;
    private Integer totalPages;
    private String previous;
    private String next;
    private List<VehicleListProperties> results;
}
