package com.swapi.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmProperties {
    private String created;
    private String edited;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> planets;
    private String producer;
    private String title;
    @JsonProperty(value = "episode_id")
    private int episodeId;
    private String director;
    @JsonProperty(value = "release_date")
    private Date releaseDate;
    @JsonProperty(value = "opening_crawl")
    private String openingCrawl;
    private List<String> characters;
    private List<String> species;
    private String url;
}
