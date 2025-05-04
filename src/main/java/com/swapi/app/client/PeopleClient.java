package com.swapi.app.client;

import com.swapi.app.model.PeopleListResponse;

public interface PeopleClient {
    PeopleListResponse getPeopleData(int page, int limit, String name);
}
