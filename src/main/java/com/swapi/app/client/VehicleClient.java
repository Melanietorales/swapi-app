package com.swapi.app.client;

import com.swapi.app.model.VehicleByIdResponse;
import com.swapi.app.model.VehicleListResponse;

public interface VehicleClient {

    VehicleListResponse getVehiclesData(int page, int limit, String name, String model);

    VehicleByIdResponse getVehicleById(int id);
}
