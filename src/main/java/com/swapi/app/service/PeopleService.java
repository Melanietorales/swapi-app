package com.swapi.app.service;

import com.swapi.app.DTO.PeopleListResponseDto;

public interface PeopleService {
    PeopleListResponseDto getPeopleData(int page, int limit, String name);
}
