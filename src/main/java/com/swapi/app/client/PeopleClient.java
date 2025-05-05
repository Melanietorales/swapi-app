package com.swapi.app.client;

import com.swapi.app.model.response.PeopleListResponse;
import com.swapi.app.model.response.PeopleIdSearchResponse;

public interface PeopleClient {
    PeopleListResponse getPeopleData(int page, int limit, String name);
    PeopleIdSearchResponse getPersonById(int id);
}
