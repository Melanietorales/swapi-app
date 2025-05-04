package com.swapi.app.service;

import com.swapi.app.DTO.PeopleListResponseDto;
import com.swapi.app.DTO.SwapiIdSearchResponseDto;

public interface PeopleService {
    PeopleListResponseDto getPeopleData(int page, int limit, String name);
    SwapiIdSearchResponseDto getPersonById(int id);
}
