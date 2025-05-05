package com.swapi.app.client.impl;

import com.swapi.app.client.VehicleClient;
import com.swapi.app.exception.GenericException;
import com.swapi.app.exception.SwapiNotFoundException;
import com.swapi.app.mapper.SwapiMapper;
import com.swapi.app.model.response.VehicleByIdResponse;
import com.swapi.app.model.response.VehicleListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class VehicleClientImpl implements VehicleClient {

    private static final Logger logger = LoggerFactory.getLogger(VehicleClientImpl.class);

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final SwapiMapper swapiMapper;

    public VehicleClientImpl(RestTemplate restTemplate, @Value("${swapi.url}") String baseUrl, SwapiMapper swapiMapper) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.swapiMapper = swapiMapper;
    }

    public VehicleListResponse getVehiclesData(int page, int limit, String name, String model) {
        logger.info("getVehiclesData - Trying to get vehicles data from swapi");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/vehicles")
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

            VehicleListResponse response = swapiMapper.mapVehiclesResponse(rawResponse, isSearch);

            if (isSearch && (response.getResults() == null || response.getResults().isEmpty())) {
                logger.error("No vehicles found with the given filters.");
                throw new SwapiNotFoundException("No vehicles found with the given filters.");
            }
            return response;

        } catch (Exception e) {
            logger.error("Error occurred while fetching vehicles: {}", e.getMessage());
            throw new GenericException("An error occurred while fetching vehicles");
        }

    }

    public VehicleByIdResponse getVehicleById(int id) {
        logger.info("getVehicleById - Trying to get vehicle data from swapi with id: {}", id);
        String url = baseUrl + "/vehicles/" + id;

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    VehicleByIdResponse.class
            ).getBody();
        } catch (HttpClientErrorException.NotFound e) {
            logger.error("Vehicle not found for id {}. Response body: {}", id, e.getResponseBodyAsString());
            throw new SwapiNotFoundException("Vehicle not found for id " + id);

        } catch (Exception e) {
            logger.error("Error occurred while fetching vehicle by id {}, error: {}", id, e.getMessage());
            throw new GenericException("An error occurred while fetching vehicle by id: " + id);
        }
    }
}
