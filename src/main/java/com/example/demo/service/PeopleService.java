package com.example.demo.service;

import com.example.demo.DTO.PeopleListResponseDto;

public interface PeopleService {
    PeopleListResponseDto getPeopleData(int page, int limit, String name);
}
