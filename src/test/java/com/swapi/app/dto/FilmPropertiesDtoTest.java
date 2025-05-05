package com.swapi.app.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmPropertiesDtoTest {

    @Test
    void testFilmPropertiesDto_SettersAndGetters() {
        FilmPropertiesDto dto = new FilmPropertiesDto();
        String created = "2014-12-10T14:23Z";
        String edited = "2014-12-10T14:23Z";
        List<String> starships = Arrays.asList("starship1", "starship2");
        List<String> vehicles = Collections.singletonList("vehicle1");
        List<String> planets = Arrays.asList("planet1", "planet2");
        String producer = "Mel";
        String title = "Phantom Menace";
        int episodeId = 1;
        String director = "George";
        Date releaseDate = new Date();
        String openingCrawl = "Turmoil in the Republic...";
        List<String> characters = Collections.singletonList("character1");
        List<String> species = Collections.singletonList("species1");
        String url = "https://swapi.dev/api/films/4/";

        dto.setCreated(created);
        dto.setEdited(edited);
        dto.setStarships(starships);
        dto.setVehicles(vehicles);
        dto.setPlanets(planets);
        dto.setProducer(producer);
        dto.setTitle(title);
        dto.setEpisodeId(episodeId);
        dto.setDirector(director);
        dto.setReleaseDate(releaseDate);
        dto.setOpeningCrawl(openingCrawl);
        dto.setCharacters(characters);
        dto.setSpecies(species);
        dto.setUrl(url);

        assertEquals(created, dto.getCreated());
        assertEquals(edited, dto.getEdited());
        assertEquals(starships, dto.getStarships());
        assertEquals(vehicles, dto.getVehicles());
        assertEquals(planets, dto.getPlanets());
        assertEquals(producer, dto.getProducer());
        assertEquals(title, dto.getTitle());
        assertEquals(episodeId, dto.getEpisodeId());
        assertEquals(director, dto.getDirector());
        assertEquals(releaseDate, dto.getReleaseDate());
        assertEquals(openingCrawl, dto.getOpeningCrawl());
        assertEquals(characters, dto.getCharacters());
        assertEquals(species, dto.getSpecies());
        assertEquals(url, dto.getUrl());
    }
}
