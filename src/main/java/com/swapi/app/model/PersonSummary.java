package com.swapi.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonSummary {
    private String uid;
    private String name;
    private String url;
    private String gender;
    @JsonProperty(value = "skin_color")
    private String skinColor;
    @JsonProperty(value = "hair_color")
    private String hairColor;
    @JsonProperty(value = "eye_color")
    private String eyeColor;
    private String height;
    private String mass;
    private String homeworld;
    private String created;
    private String edited;
    @JsonProperty(value = "birth_year")
    private String birthYear;

}
