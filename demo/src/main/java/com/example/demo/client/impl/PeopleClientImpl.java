package com.example.demo.client.impl;

import com.example.demo.client.PeopleClient;
import com.example.demo.mapper.SwapiMapper;
import com.example.demo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class PeopleClientImpl implements PeopleClient {

    private static final Logger logger = LoggerFactory.getLogger(PeopleClientImpl.class);

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final SwapiMapper swapiMapper;

    public PeopleClientImpl(RestTemplate restTemplate, @Value("${swapi.url}") String baseUrl,SwapiMapper swapiMapper) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.swapiMapper = swapiMapper;
    }

    /**
     * Obtiene los datos de las personas, incluyendo filtrado por nombre y paginación.
     *
     * @param page  Página de resultados a recuperar.
     * @param limit Número máximo de resultados por página.
     * @param name  Filtro opcional por nombre de la persona.
     * @return Una lista de personas con los datos completos.
     */

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

        String rawResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        ).getBody();

        return swapiMapper.mapResponse(rawResponse, isSearch, page);
    }


}
