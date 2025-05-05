package com.swapi.app.service;

import com.swapi.app.dto.PeopleListResponseDto;
import com.swapi.app.dto.PersonSummaryDto;

public interface PeopleService {
    PeopleListResponseDto getPeopleData(int page, int limit, String name);
    PersonSummaryDto getPersonById(int id);
}
