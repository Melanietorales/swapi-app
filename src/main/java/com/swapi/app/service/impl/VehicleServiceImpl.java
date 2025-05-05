package com.swapi.app.service.impl;

import com.swapi.app.client.VehicleClient;
import com.swapi.app.dto.VehicleByIdResponseDto;
import com.swapi.app.dto.VehicleListResponseDto;
import com.swapi.app.mapper.VehicleByIdResponsetoDto;
import com.swapi.app.mapper.VehicleListResponseToDto;
import com.swapi.app.model.response.VehicleByIdResponse;
import com.swapi.app.model.response.VehicleListResponse;
import com.swapi.app.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleClient vehicleClient;

    public VehicleServiceImpl(VehicleClient vehicleClient) {
        this.vehicleClient = vehicleClient;
    }

    @Override
    public VehicleListResponseDto getVehiclesData (int page, int limit, String name, String model) {
        VehicleListResponse response = vehicleClient.getVehiclesData(page, limit, name, model);
        return VehicleListResponseToDto.toDto(response);
    }

    @Override
    public VehicleByIdResponseDto getVehicleById (int id){
        VehicleByIdResponse response = vehicleClient.getVehicleById(id);
        return VehicleByIdResponsetoDto.toDto(response);
    }
}
