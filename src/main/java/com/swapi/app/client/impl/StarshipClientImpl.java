package com.swapi.app.client.impl;

import com.swapi.app.client.StarshipClient;
import com.swapi.app.exception.GenericException;
import com.swapi.app.exception.SwapiNotFoundException;
import com.swapi.app.mapper.SwapiMapper;
import com.swapi.app.model.response.StarshipListResponse;
import com.swapi.app.model.response.StarshipByIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class StarshipClientImpl implements StarshipClient {

    private static final Logger logger = LoggerFactory.getLogger(FilmClientImpl.class);

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final SwapiMapper swapiMapper;

    public StarshipClientImpl(RestTemplate restTemplate, @Value("${swapi.url}") String baseUrl, SwapiMapper swapiMapper) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.swapiMapper = swapiMapper;
    }

    public StarshipListResponse getStarshipData(int page, int limit, String name, String model) {
        logger.info("getStarshipData - Trying to get starship data from swapi");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/starships")
                .queryParam("page", page)
                .queryParam("limit", limit);

        boolean isSearch = name != null && !name.isEmpty() || model != null && !model.isEmpty();
        if (name != null && !name.isEmpty()) {
            uriBuilder.queryParam("name", name);
        }

        if (model != null && !model.isEmpty()) {
            uriBuilder.queryParam("model", model);
        }

        String url = uriBuilder.toUriString();

        try {
            String rawResponse = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    String.class
            ).getBody();

            StarshipListResponse response = swapiMapper.mapStarshipResponse(rawResponse, isSearch);
            if (isSearch && (response.getResults() == null || response.getResults().isEmpty())) {
                logger.error("No starship found with the given filters.");
                throw new SwapiNotFoundException("No starship found with the given filters.");
            }
            return response;

        } catch (Exception e) {
            logger.error("Error occurred while fetching starship: {}", e.getMessage());
            throw new GenericException("An error occurred while fetching starship");
        }
    }

    public StarshipByIdResponse getStarshipById(int id) {
        logger.info("getStashipById - Trying to get starship data from swapi with id: {}", id);
        String url = baseUrl + "/starships/" + id;

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    StarshipByIdResponse.class
            ).getBody();
        } catch (HttpClientErrorException.NotFound e) {
            logger.error("Starship not found for id {}. Response body: {}", id, e.getResponseBodyAsString());
            throw new SwapiNotFoundException("Starship not found for id " + id);

        } catch (Exception e) {
            logger.error("Error occurred while fetching starship by id {}, error: {}", id, e.getMessage());
            throw new GenericException("An error occurred while fetching starship by id: " + id);
        }
    }

}
