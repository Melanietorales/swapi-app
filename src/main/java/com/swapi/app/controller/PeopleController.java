package com.swapi.app.controller;

import com.swapi.app.dto.PeopleListResponseDto;
import com.swapi.app.dto.PersonSummaryDto;
import com.swapi.app.service.PeopleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public ResponseEntity<PeopleListResponseDto> getAllPeople(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String name
    ) {
        return ResponseEntity.ok(peopleService.getPeopleData(page, limit, name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonSummaryDto> getPersonById(
            @PathVariable int id
    ) {
        return ResponseEntity.ok(peopleService.getPersonById(id));
    }
}
