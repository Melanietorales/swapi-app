package com.example.demo.client;

import com.example.demo.model.PeopleListResponse;

public interface PeopleClient {
    PeopleListResponse getPeopleData(int page, int limit, String name);
}
