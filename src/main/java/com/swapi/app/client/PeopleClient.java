package com.swapi.app.client;

import com.swapi.app.model.PeopleListResponse;
import com.swapi.app.model.SwapiIdSearchResponse;

public interface PeopleClient {
    PeopleListResponse getPeopleData(int page, int limit, String name);
    SwapiIdSearchResponse getPersonById(int id);
}
