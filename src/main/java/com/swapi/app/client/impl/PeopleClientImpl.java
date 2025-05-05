package com.swapi.app.client.impl;

import com.swapi.app.client.PeopleClient;
import com.swapi.app.exception.GenericException;
import com.swapi.app.exception.SwapiNotFoundException;
import com.swapi.app.mapper.SwapiMapper;
import com.swapi.app.model.response.PeopleListResponse;
import com.swapi.app.model.response.PeopleIdSearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class PeopleClientImpl implements PeopleClient {

    private static final Logger logger = LoggerFactory.getLogger(PeopleClientImpl.class);

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final SwapiMapper swapiMapper;

    public PeopleClientImpl(RestTemplate restTemplate, @Value("${swapi.url}") String baseUrl, SwapiMapper swapiMapper) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.swapiMapper = swapiMapper;
    }

    @Override
    public PeopleListResponse getPeopleData(int page, int limit, String name) {
        logger.info("getPeopleData - Trying to get people data from swapi");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/people")
                .queryParam("page", page)
                .queryParam("limit", limit);

        boolean isSearch = name != null && !name.isEmpty();
        if (isSearch) {
            uriBuilder.queryParam("name", name);
        }

        String url = uriBuilder.toUriString();

        try {
            String rawResponse = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    String.class
            ).getBody();

            PeopleListResponse response = swapiMapper.mapPeopleResponse(rawResponse, isSearch, page);
            if (isSearch && (response.getResults() == null || response.getResults().isEmpty())) {
                logger.error("No people found with the given filters.");
                throw new SwapiNotFoundException("No people found with the given filters.");
            }
            return response;

        } catch (Exception e) {
            logger.error("Error occurred while fetching people: {}", e.getMessage());
            throw new GenericException("An error occurred while fetching people");
        }

    }

    @Override
    public PeopleIdSearchResponse getPersonById(int id) {
        logger.info("getPeopleData - Trying to get people data from swapi with id: {}", id);
        String url = baseUrl + "/people/" + id;

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    PeopleIdSearchResponse.class
            ).getBody();

        } catch (HttpClientErrorException.NotFound e) {
            logger.error("Person not found for id {}. Response body: {}", id, e.getResponseBodyAsString());
            throw new SwapiNotFoundException("Person not found for id " + id);

        } catch (Exception e) {
            logger.error("Error occurred while fetching person by id {}, error: {}", id, e.getMessage());
            throw new GenericException("An error occurred while fetching person by id: " + id);
        }
    }

}
