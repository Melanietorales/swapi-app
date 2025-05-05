package com.swapi.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FilmPropertiesDto {
    @Schema(description = "the ISO 8601 date format of the time that this resource was created.", example = "2014-12-10T14:23:31.880000Z")
    private String created;
    @Schema(description = "The ISO 8601 date format of the time that this resource was edited.", example = "2014-12-12T11:26:08.000000Z")

    private String edited;
    @Schema(description = "An array of starship resource URLs that are in this film.")

    private List<String> starships;
    @Schema(description = "An array of vehicle resource URLs that are in this film.")

    private List<String> vehicles;
    @Schema(description = "An array of planet resource URLs that are in this film.")

    private List<String> planets;
    @Schema(description = "The name(s) of the producer(s) of this film. Comma separated.", example = "Rick McCallum")

    private String producer;
    @Schema(description = "The title of this film.", example = "The Phantom Menace")

    private String title;

    @Schema(description = "The episode number of this film.", example = "1")
    private int episodeId;

    @Schema(description = "The name of the director of this film.", example = "George Lucas")
    private String director;

    @Schema(description = "The ISO 8601 date format of film release at original creator country.", example = "1999-05-19")
    private Date releaseDate;

    @Schema(description = "The opening paragraphs at the beginning of this film.", example = "Turmoil has engulfed the Galactic Republic...")
    private String openingCrawl;

    @Schema(description = "An array of people resource URLs that are in this film.")
    private List<String> characters;

    @Schema(description = "An array of species resource URLs that are in this film.")
    private List<String> species;

    @Schema(description = "The hypermedia URL of this resource.", example = "https://swapi.dev/api/films/4/")
    private String url;
}
