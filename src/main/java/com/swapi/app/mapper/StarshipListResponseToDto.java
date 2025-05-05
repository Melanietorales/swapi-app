package com.swapi.app.mapper;

import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.dto.SwapiStarshipPropertiesDto;
import com.swapi.app.model.response.StarshipListResponse;
import com.swapi.app.model.response.StarshipProperties;

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

    private static SwapiStarshipPropertiesDto mapStarshipResultsToDto(StarshipProperties starshipProperties) {
        return SwapiStarshipPropertiesDto.builder()
                .uid(starshipProperties.getUid())
                .name(starshipProperties.getName())
                .url(starshipProperties.getUrl())
                .created(starshipProperties.getCreated())
                .edited(starshipProperties.getEdited())
                .consumables(starshipProperties.getConsumables())
                .cargoCapacity(starshipProperties.getCargoCapacity())
                .passengers(starshipProperties.getPassengers())
                .maxAtmospheringSpeed(starshipProperties.getMaxAtmospheringSpeed())
                .crew(starshipProperties.getCrew())
                .length(starshipProperties.getLength())
                .model(starshipProperties.getModel())
                .costInCredits(starshipProperties.getCostInCredits())
                .manufacturer(starshipProperties.getManufacturer())
                .pilots(starshipProperties.getPilots())
                .MGLT(starshipProperties.getMglt())
                .starshipClass(starshipProperties.getStarshipClass())
                .hyperdriveRating(starshipProperties.getHyperdriveRating())
                .films(starshipProperties.getFilms())
                .build();
    }
}
