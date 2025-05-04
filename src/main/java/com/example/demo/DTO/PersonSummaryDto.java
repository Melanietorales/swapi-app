package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonSummaryDto {
    @Schema(description = "identificator of the person", example = "1")
    private String uid;

    @Schema(description = "The name of the person", example = "Luke Skywalker")
    private String name;

    @Schema(description = "The hypermedia URL of this resource.", example = "https://www.swapi.tech/api/people/1/")
    private String url;

    @Schema(description = "The gender of this person.", example = "Male")
    private String gender;

    @Schema(description = "The skin color of this person.", example = "Fair")
    private String skinColor;

    @Schema(description = "The hair color of this person.", example = "Blond")
    private String hairColor;

    @Schema(description = "The eye color of this person", example = "Blue")
    private String eyeColor;

    @Schema(description = "The height of the person in centimeters.", example = "172")
    private String height;

    @Schema(description = "The mass of the person in kilograms.", example = "80")
    private String mass;

    @Schema(description = "The URL of a planet resource", example = "https://www.swapi.tech/api/planets/1/")
    private String homeworld;

    @Schema(description = "The ISO 8601 date format of the time that this resource was created.", example = "2014-12-09T13:50:51.644000Z")
    private String created;

    @Schema(description = "The ISO 8601 date format of the time that this resource was edited.", example = "2014-12-10T13:52:43.172000Z")
    private String edited;

    @Schema(description = "The birth year of the person", example = "19 BBY")
    private String birthYear;

}
