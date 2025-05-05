package com.swapi.app.mapper;

import com.swapi.app.dto.VehicleListPropertiesDto;
import com.swapi.app.dto.VehicleListResponseDto;
import com.swapi.app.model.VehicleListProperties;
import com.swapi.app.model.VehicleListResponse;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleListResponseToDto {

    public static VehicleListResponseDto toDto(VehicleListResponse response) {
        List<VehicleListPropertiesDto> dtoList = response.getResults().stream()
                .map(VehicleListResponseToDto::mapVehicleResultsToDto)
                .collect(Collectors.toList());

        return VehicleListResponseDto.builder()
                .totalRecords(response.getTotalRecords())
                .totalPages(response.getTotalPages())
                .previous(response.getPrevious())
                .next(response.getNext())
                .results(dtoList)
                .build();
    }

    private static VehicleListPropertiesDto mapVehicleResultsToDto(VehicleListProperties vehicleListProperties) {
        return VehicleListPropertiesDto.builder()
                .uid(vehicleListProperties.getUid())
                .created(vehicleListProperties.getCreated())
                .edited(vehicleListProperties.getEdited())
                .consumables(vehicleListProperties.getConsumables())
                .name(vehicleListProperties.getName())
                .cargoCapacity(vehicleListProperties.getCargoCapacity())
                .passengers(vehicleListProperties.getPassengers())
                .maxAtmospheringSpeed(vehicleListProperties.getMaxAtmospheringSpeed())
                .crew(vehicleListProperties.getCrew())
                .length(vehicleListProperties.getLength())
                .model(vehicleListProperties.getModel())
                .costInCredits(vehicleListProperties.getCostInCredits())
                .manufacturer(vehicleListProperties.getManufacturer())
                .vehicleClass(vehicleListProperties.getVehicleClass())
                .pilots(vehicleListProperties.getPilots())
                .films(vehicleListProperties.getFilms())
                .url(vehicleListProperties.getUrl())
                .build();
    }
}
