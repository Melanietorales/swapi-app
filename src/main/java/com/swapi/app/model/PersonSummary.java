package com.swapi.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonSummary {
    private String uid;
    private String name;
    private String url;

    private String gender;
    private String skinColor;
    private String hairColor;
    private String eyeColor;
    private String height;
    private String mass;
    private String homeworld;
    private String created;
    private String edited;
    private String birthYear;

}
