package com.swapi.app.mapper;

import com.swapi.app.dto.VehicleByIdResponseDto;
import com.swapi.app.dto.VehicleListPropertiesDto;
import com.swapi.app.dto.VehicleListResultsDto;
import com.swapi.app.model.response.VehicleByIdResponse;
import com.swapi.app.model.response.VehicleListProperties;

public class VehicleByIdResponsetoDto {

    public static VehicleByIdResponseDto toDto(VehicleByIdResponse response) {
        VehicleListProperties properties = response.getResult().getProperties();
        VehicleListPropertiesDto propertiesDto = new VehicleListPropertiesDto();
        propertiesDto.setUid(properties.getUid());
        propertiesDto.setCreated(properties.getCreated());
        propertiesDto.setEdited(properties.getEdited());
        propertiesDto.setConsumables(properties.getConsumables());
        propertiesDto.setName(properties.getName());
        propertiesDto.setCargoCapacity(properties.getCargoCapacity());
        propertiesDto.setPassengers(properties.getPassengers());
        propertiesDto.setMaxAtmospheringSpeed(properties.getMaxAtmospheringSpeed());
        propertiesDto.setCrew(properties.getCrew());
        propertiesDto.setLength(properties.getLength());
        propertiesDto.setModel(properties.getModel());
        propertiesDto.setCostInCredits(properties.getCostInCredits());
        propertiesDto.setManufacturer(properties.getManufacturer());
        propertiesDto.setVehicleClass(properties.getVehicleClass());
        propertiesDto.setPilots(properties.getPilots());
        propertiesDto.setFilms(properties.getFilms());
        propertiesDto.setUrl(properties.getUrl());

        VehicleListResultsDto vehicleListResultsDto = new VehicleListResultsDto();
        vehicleListResultsDto.setProperties(propertiesDto);

        return VehicleByIdResponseDto.builder()
                .result(vehicleListResultsDto)
                .build();
    }
}
