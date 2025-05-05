package com.swapi.app.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SwapiStarshipResultsDto {

    @Schema(description = "Unique identifier for the starship", example = "10")
    private String uid;

    @Schema(description = "The name of this starship. The common name, such as 'Death Star'.", example = "Death Star")
    private String name;

    @Schema(description = "The hypermedia URL of this resource.", example = "https://www.swapi.tech/api/starships/9")
    private String url;

    @Schema(description = "The ISO 8601 date format of the time that this resource was created.", example = "2014-12-10T16:36:50.509000Z")
    private String created;

    @Schema(description = "The ISO 8601 date format of the time that this resource was edited.", example = "2014-12-20T21:23:49.867000Z")
    private String edited;

    @Schema(description = "The maximum length of time that this starship can provide consumables for its entire crew without having to resupply.", example = "2 years")
    private String consumables;

    @Schema(description = "The maximum number of kilograms that this starship can transport.", example = "1000000000000")
    private String cargoCapacity;

    @Schema(description = "The number of non-essential people this starship can transport.", example = "843342")
    private String passengers;

    @Schema(description = "The maximum speed of this starship in the atmosphere. 'N/A' if this starship is incapable of atmospheric flight.", example = "1000")
    private String maxAtmospheringSpeed;

    @Schema(description = "The number of personnel needed to run or pilot this starship.", example = "342953")
    private String crew;

    @Schema(description = "The length of this starship in meters.", example = "120000")
    private String length;

    @Schema(description = "The model or official name of this starship.", example = "DS-1 Orbital Battle Station")
    private String model;

    @Schema(description = "The cost of this starship new, in galactic credits.", example = "1000000000000")
    private String costInCredits;

    @Schema(description = "The manufacturer of this starship. Comma separated if more than one.", example = "Imperial Department of Military Research, Sienar Fleet Systems")
    private String manufacturer;

    @Schema(description = "An array of People URL Resources that this starship has been piloted by.", example = "[\"https://www.swapi.tech/api/people/1\"]")
    private List<String> pilots;

    @Schema(description = "The Maximum number of Megalights this starship can travel in a standard hour.", example = "10")
    private String MGLT;

    @Schema(description = "The class of this starship, such as 'Starfighter' or 'Deep Space Mobile Battlestation'.", example = "Deep Space Mobile Battlestation")
    private String starshipClass;

    @Schema(description = "The class of this starships hyperdrive.", example = "4.0")
    private String hyperdriveRating;

    @Schema(description = "An array of Film URL Resources that this starship has appeared in.", example = "[\"https://www.swapi.tech/api/films/1\"]")
    private List<String> films;

}
