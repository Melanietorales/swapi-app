package com.swapi.app.mapper;

import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.dto.SwapiStarshipPropertiesDto;
import com.swapi.app.model.StarshipListResponse;
import com.swapi.app.model.SwapiStarshipProperties;

import java.util.List;
import java.util.stream.Collectors;

public class StarshipListResponseToDto {

    public static StarshipListResponseDto toDto(StarshipListResponse response) {
        List<SwapiStarshipPropertiesDto> dtoList = response.getResults().stream()
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

    private static SwapiStarshipPropertiesDto mapStarshipResultsToDto(SwapiStarshipProperties swapiStarshipProperties) {
        return SwapiStarshipPropertiesDto.builder()
                .uid(swapiStarshipProperties.getUid())
                .name(swapiStarshipProperties.getName())
                .url(swapiStarshipProperties.getUrl())
                .created(swapiStarshipProperties.getCreated())
                .edited(swapiStarshipProperties.getEdited())
                .consumables(swapiStarshipProperties.getConsumables())
                .cargoCapacity(swapiStarshipProperties.getCargoCapacity())
                .passengers(swapiStarshipProperties.getPassengers())
                .maxAtmospheringSpeed(swapiStarshipProperties.getMaxAtmospheringSpeed())
                .crew(swapiStarshipProperties.getCrew())
                .length(swapiStarshipProperties.getLength())
                .model(swapiStarshipProperties.getModel())
                .costInCredits(swapiStarshipProperties.getCostInCredits())
                .manufacturer(swapiStarshipProperties.getManufacturer())
                .pilots(swapiStarshipProperties.getPilots())
                .MGLT(swapiStarshipProperties.getMglt())
                .starshipClass(swapiStarshipProperties.getStarshipClass())
                .hyperdriveRating(swapiStarshipProperties.getHyperdriveRating())
                .films(swapiStarshipProperties.getFilms())
                .build();
    }
}
