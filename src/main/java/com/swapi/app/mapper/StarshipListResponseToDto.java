package com.swapi.app.mapper;

import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.dto.SwapiStarshipResultsDto;
import com.swapi.app.model.StarshipListResponse;
import com.swapi.app.model.SwapiStarshipResults;

import java.util.List;
import java.util.stream.Collectors;

public class StarshipListResponseToDto {

    public static StarshipListResponseDto toDto(StarshipListResponse response) {
        List<SwapiStarshipResultsDto> dtoList = response.getResults().stream()
                .map(StarshipListResponseToDto::mapStarshipResultsToDto)
                .collect(Collectors.toList());

        return StarshipListResponseDto.builder()
                .totalRecords(response.getTotalRecords())
                .totalPages(response.getTotalPages())
                .previous(response.getPrevious())
                .next(response.getNext())
                .results(dtoList)
                .build();
    }

    private static SwapiStarshipResultsDto mapStarshipResultsToDto(SwapiStarshipResults swapiStarshipResults) {
        return SwapiStarshipResultsDto.builder()
                .uid(swapiStarshipResults.getUid())
                .name(swapiStarshipResults.getName())
                .url(swapiStarshipResults.getUrl())
                .created(swapiStarshipResults.getCreated())
                .edited(swapiStarshipResults.getEdited())
                .consumables(swapiStarshipResults.getConsumables())
                .cargoCapacity(swapiStarshipResults.getCargoCapacity())
                .passengers(swapiStarshipResults.getPassengers())
                .maxAtmospheringSpeed(swapiStarshipResults.getMaxAtmospheringSpeed())
                .crew(swapiStarshipResults.getCrew())
                .length(swapiStarshipResults.getLength())
                .model(swapiStarshipResults.getModel())
                .costInCredits(swapiStarshipResults.getCostInCredits())
                .manufacturer(swapiStarshipResults.getManufacturer())
                .pilots(swapiStarshipResults.getPilots())
                .MGLT(swapiStarshipResults.getMGLT())
                .starshipClass(swapiStarshipResults.getStarshipClass())
                .hyperdriveRating(swapiStarshipResults.getHyperdriveRating())
                .films(swapiStarshipResults.getFilms())
                .build();
    }
}
