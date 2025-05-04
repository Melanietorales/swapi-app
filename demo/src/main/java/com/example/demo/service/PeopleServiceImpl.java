package com.example.demo.service;

import com.example.demo.DTO.PeopleListResponseDto;
import com.example.demo.client.PeopleClient;
import com.example.demo.mapper.PeopleListResponseToDto;
import com.example.demo.model.PeopleListResponse;

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
