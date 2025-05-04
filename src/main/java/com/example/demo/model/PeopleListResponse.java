package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PeopleListResponse {
    private int totalRecords;
    private int totalPages;
    private int currentPage;
    private List<PersonSummary> results;
}
