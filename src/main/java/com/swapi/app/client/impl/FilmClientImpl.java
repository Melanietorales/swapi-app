package com.swapi.app.client.impl;

import com.swapi.app.client.FilmClient;
import com.swapi.app.exception.GenericException;
import com.swapi.app.exception.SwapiNotFoundException;
import com.swapi.app.model.response.FilmByIdResponse;
import com.swapi.app.model.response.FilmListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
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

    public FilmListResponse getFilmsData(int page, int limit, String title) {
        logger.info("getFilmsData - Trying to get films data from swapi");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/films")
                .queryParam("page", page)
                .queryParam("limit", limit);

        if (title != null && !title.isEmpty()) {
            uriBuilder.queryParam("title", title);
        }

        String url = uriBuilder.toUriString();

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    FilmListResponse.class
            ).getBody();

        } catch (HttpClientErrorException.NotFound e) {
            logger.error("No films found with the given filters.");
            throw new SwapiNotFoundException("No films found with the given filters.");

        } catch (Exception e) {
            logger.error("Error occurred while fetching films: {}", e.getMessage());
            throw new GenericException("An error occurred while fetching films");
        }

    }

    public FilmByIdResponse getFilmDataById(int id) {
        logger.info("getFilmsDataById - Trying to get films data from swapi with id: {}", id);
        String url = baseUrl + "/films/" + id;

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    FilmByIdResponse.class
            ).getBody();

        } catch (HttpClientErrorException.NotFound e) {
            logger.error("Film not found for id {}. Response body: {}", id, e.getResponseBodyAsString());
            throw new SwapiNotFoundException("Film not found for id " + id);

        } catch (Exception e) {
            logger.error("Error occurred while fetching films by id {}, error: {}",id, e.getMessage());
            throw new GenericException("An error occurred while fetching films by id: " + id);
        }

    }

}
