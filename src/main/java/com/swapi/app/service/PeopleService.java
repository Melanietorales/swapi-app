package com.swapi.app.service;

import com.swapi.app.DTO.PeopleListResponseDto;
import com.swapi.app.DTO.PersonSummaryDto;

public interface PeopleService {
    PeopleListResponseDto getPeopleData(int page, int limit, String name);
    PersonSummaryDto getPersonById(int id);
}
