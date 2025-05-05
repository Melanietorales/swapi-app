package com.swapi.app.controller;

import com.swapi.app.dto.PeopleListResponseDto;
import com.swapi.app.dto.PersonSummaryDto;
import com.swapi.app.service.impl.PeopleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PeopleControllerTest {

    @Test
    void testGetAllPeople_OK() {
        PeopleServiceImpl peopleService = mock(PeopleServiceImpl.class);
        PeopleController controller = new PeopleController(peopleService);

        PersonSummaryDto person = createPersonSummaryDto();
        PeopleListResponseDto expectedResponse = PeopleListResponseDto.builder()
                .totalRecords(1)
                .totalPages(1)
                .currentPage(1)
                .results(Collections.singletonList(person))
                .build();

        when(peopleService.getPeopleData(1, 10, null)).thenReturn(expectedResponse);

        ResponseEntity<PeopleListResponseDto> response = controller.getAllPeople(1, 10, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testGetPersonById_OK() {
        PeopleServiceImpl peopleService = mock(PeopleServiceImpl.class);
        PeopleController controller = new PeopleController(peopleService);

        PersonSummaryDto expectedPerson = createPersonSummaryDto();
        when(peopleService.getPersonById(1)).thenReturn(expectedPerson);

        ResponseEntity<PersonSummaryDto> response = controller.getPersonById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPerson, response.getBody());
    }

    private PersonSummaryDto createPersonSummaryDto() {
        return PersonSummaryDto.builder()
                .uid("1")
                .name("Luke Skywalker")
                .url("https://www.swapi.tech/api/people/1/")
                .gender("Male")
                .skinColor("Fair")
                .hairColor("Blond")
                .eyeColor("Blue")
                .height("172")
                .mass("80")
                .homeworld("https://www.swapi.tech/api/planets/1/")
                .created("2014-12-09T13:50:51.644000Z")
                .edited("2014-12-10T13:52:43.172000Z")
                .birthYear("19 BBY")
                .build();
    }
}
