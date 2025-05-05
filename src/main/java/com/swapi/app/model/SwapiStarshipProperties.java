package com.swapi.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwapiStarshipProperties {
    private String uid;
    private String name;
    private String url;
    private String created;
    private String edited;
    private String consumables;
    @JsonProperty(value = "cargo_capacity")
    private  String cargoCapacity;
    private String passengers;
    @JsonProperty(value = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    private String crew;
    private String length;
    private String model;
    @JsonProperty(value = "cost_in_credits")
    private String costInCredits;
    private String manufacturer;
    private List<String> pilots;
    @JsonProperty(value = "MGLT")
    private String mglt;
    @JsonProperty(value = "starship_class")
    private String starshipClass;
    @JsonProperty(value = "hyperdrive_rating")
    private String hyperdriveRating;
    private List<String> films;

}
