package com.swapi.app.controller;

import com.swapi.app.dto.VehicleByIdResponseDto;
import com.swapi.app.dto.VehicleListResponseDto;
import com.swapi.app.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Operation(summary = "Get vehicles data", description = "Retrieve a paginated list of vehicles. Optionally, filter by name or model.")
    @GetMapping
    public ResponseEntity<VehicleListResponseDto> getVehiclesData(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String model
    ) {
        logger.info("VehicleController - getVehiclesData - page: {}, limit: {}, name: {}, model: {}", page, limit, name, model);
        return ResponseEntity.ok(vehicleService.getVehiclesData(page, limit, name, model));
    }

    @Operation(summary = "Get vehicle by ID", description = "Retrieve details of a vehicle by its unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleByIdResponseDto> getVehicleById(
            @PathVariable int id
    ) {
        logger.info("VehicleController - getVehicleById - id: {}", id);
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }
}
