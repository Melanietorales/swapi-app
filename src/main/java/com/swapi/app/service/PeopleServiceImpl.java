package com.swapi.app.service;

import com.swapi.app.DTO.PeopleListResponseDto;
import com.swapi.app.DTO.PersonSummaryDto;
import com.swapi.app.client.PeopleClient;
import com.swapi.app.mapper.PeopleListResponseToDto;
import com.swapi.app.mapper.SwapiIdSearchResponseToDto;
import com.swapi.app.model.PeopleListResponse;
import com.swapi.app.model.SwapiIdSearchResponse;

public class PeopleServiceImpl implements PeopleService {

    private final PeopleClient peopleClient;

    public PeopleServiceImpl(PeopleClient peopleClient) {
        this.peopleClient = peopleClient;
    }

    @Override
    public PeopleListResponseDto getPeopleData (int page, int limit, String name) {
        PeopleListResponse response = peopleClient.getPeopleData(page, limit, name);
        return PeopleListResponseToDto.toDto(response);
    }

    @Override
    public PersonSummaryDto getPersonById (int id) {
        SwapiIdSearchResponse response = peopleClient.getPersonById(id);
        return SwapiIdSearchResponseToDto.toDto(response);
    }
}
