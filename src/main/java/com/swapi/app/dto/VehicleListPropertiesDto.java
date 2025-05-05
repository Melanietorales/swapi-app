package com.swapi.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleListPropertiesDto {

    @Schema(description = "Unique identifier for the vehicle", example = "abc123")
    private String uid;

    @Schema(description = "The ISO 8601 date format of the time that this resource was created", example = "2014-12-10T15:36:25.724000Z")
    private String created;

    @Schema(description = "The ISO 8601 date format of the time that this resource was edited", example = "2014-12-20T21:30:21.661000Z")
    private String edited;

    @Schema(description = "The maximum length of time that this vehicle can provide consumables for its entire crew without having to resupply", example = "2 months")
    private String consumables;

    @Schema(description = "The name of this vehicle", example = "Sand Crawler")
    private String name;

    @Schema(description = "The maximum number of kilograms that this vehicle can transport", example = "50000")
    private String cargoCapacity;

    @Schema(description = "The number of non-essential people this vehicle can transport", example = "30")
    private String passengers;

    @Schema(description = "The maximum speed of this vehicle in the atmosphere", example = "250")
    private String maxAtmospheringSpeed;

    @Schema(description = "The number of personnel needed to run or pilot this vehicle", example = "46")
    private String crew;

    @Schema(description = "The length of this vehicle in meters", example = "36.8")
    private String length;

    @Schema(description = "The model or official name of this vehicle", example = "Digger Crawler")
    private String model;

    @Schema(description = "The cost of this vehicle new, in Galactic Credits", example = "150000")
    private String costInCredits;

    @Schema(description = "The manufacturer of this vehicle. Comma separated if more than one.", example = "Corellia Mining Corporation")
    private String manufacturer;

    @Schema(description = "The class of this vehicle", example = "Wheeled")
    private String vehicleClass;

    @Schema(description = "An array of People URL Resources that this vehicle has been piloted by", example = "[\"https://swapi.dev/api/people/1/\"]")
    private List<String> pilots;

    @Schema(description = "An array of Film URL Resources that this vehicle has appeared in", example = "[\"https://swapi.dev/api/films/1/\"]")
    private List<String> films;

    @Schema(description = "The hypermedia URL of this resource", example = "https://swapi.dev/api/vehicles/4/")
    private String url;

}
