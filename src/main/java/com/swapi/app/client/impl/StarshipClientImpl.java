package com.swapi.app.client.impl;

import com.swapi.app.client.StarshipClient;
import com.swapi.app.mapper.SwapiMapper;
import com.swapi.app.model.StarshipListResponse;
import com.swapi.app.model.SwapiStarshipByIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
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

        String rawResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        ).getBody();

        return swapiMapper.mapStarshipResponse(rawResponse, isSearch, page);
    }

    public SwapiStarshipByIdResponse getStarshipById(int id) {
        logger.info("getStashipById - Trying to get starship data from swapi with id: {}", id);
        String url = baseUrl + "/starships/" + id;

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                SwapiStarshipByIdResponse.class
        ).getBody();
    }

}
