package com.swapi.app.controller;

import com.swapi.app.dto.PeopleListResponseDto;
import com.swapi.app.dto.PersonSummaryDto;
import com.swapi.app.service.PeopleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Operation(summary = "Get all people", description = "Retrieve a paginated list of people. Optionally, filter by name.")
    @GetMapping
    public ResponseEntity<PeopleListResponseDto> getAllPeople(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String name
    ) {
        return ResponseEntity.ok(peopleService.getPeopleData(page, limit, name));
    }

    @Operation(summary = "Get person by ID", description = "Retrieve details of a person by their unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<PersonSummaryDto> getPersonById(
            @PathVariable int id
    ) {
        return ResponseEntity.ok(peopleService.getPersonById(id));
    }
}
