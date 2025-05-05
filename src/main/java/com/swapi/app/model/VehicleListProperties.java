package com.swapi.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleListProperties {
    private String uid;
    private String created;
    private String edited;
    private String consumables;
    private String name;
    @JsonProperty(value = "cargo_capacity")
    private String cargoCapacity;
    private String passengers;
    @JsonProperty(value = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    private String crew;
    private String length;
    private String model;
    @JsonProperty(value = "cost_in_credits")
    private String costInCredits;
    private String manufacturer;
    @JsonProperty(value = "vehicle_class")
    private String vehicleClass;
    private List<String> pilots;
    private List<String> films;
    private String url;
}
