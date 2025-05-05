package com.swapi.app.controller;

import com.swapi.app.dto.PeopleListResponseDto;
import com.swapi.app.dto.PersonSummaryDto;
import com.swapi.app.service.PeopleService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/people")
public class PeopleController {

    private static final Logger logger = LoggerFactory.getLogger(PeopleController.class);
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
        logger.info("PeopleController - getAllPeople - page: {}, limit: {}, name: {}", page, limit, name);
        return ResponseEntity.ok(peopleService.getPeopleData(page, limit, name));
    }

    @Operation(summary = "Get person by ID", description = "Retrieve details of a person by their unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<PersonSummaryDto> getPersonById(
            @PathVariable int id
    ) {
        logger.info("PeopleController - getPersonById - id: {}", id);
        return ResponseEntity.ok(peopleService.getPersonById(id));
    }
}
