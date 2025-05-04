package com.swapi.app.service;

import com.swapi.app.DTO.PeopleListResponseDto;
import com.swapi.app.client.PeopleClient;
import com.swapi.app.mapper.PeopleListResponseToDto;
import com.swapi.app.model.PeopleListResponse;

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
}
