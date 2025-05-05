package com.swapi.app.service;

import com.swapi.app.dto.VehicleByIdResponseDto;
import com.swapi.app.dto.VehicleListResponseDto;

public interface VehicleService {

    VehicleListResponseDto getVehiclesData (int page, int limit, String name, String model);

    VehicleByIdResponseDto getVehicleById (int id);
}
