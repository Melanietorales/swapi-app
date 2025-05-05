package com.swapi.app.client.impl;

import com.swapi.app.client.FilmClient;
import com.swapi.app.model.SwapiFilmByIdResponse;
import com.swapi.app.model.SwapiFilmListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class FilmClientImpl implements FilmClient {

    private static final Logger logger = LoggerFactory.getLogger(FilmClientImpl.class);

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public FilmClientImpl(RestTemplate restTemplate, @Value("${swapi.url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public SwapiFilmListResponse getFilmsData(int page, int limit, String title) {
        logger.info("getFilmsData - Trying to get films data from swapi");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/films")
                .queryParam("page", page)
                .queryParam("limit", limit);

        if (title != null && !title.isEmpty()) {
            uriBuilder.queryParam("title", title);
        }

        String url = uriBuilder.toUriString();

       return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
               SwapiFilmListResponse.class
        ).getBody();
    }

    public SwapiFilmByIdResponse getFilmDataById(int id) {
        logger.info("getFilmsDataById - Trying to get films data from swapi with id: {}", id);
        String url = baseUrl + "/films/" + id;

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                SwapiFilmByIdResponse.class
        ).getBody();
    }

}
