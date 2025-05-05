package com.swapi.app.client;

import com.swapi.app.model.response.VehicleByIdResponse;
import com.swapi.app.model.response.VehicleListResponse;

public interface VehicleClient {

    VehicleListResponse getVehiclesData(int page, int limit, String name, String model);

    VehicleByIdResponse getVehicleById(int id);
}
