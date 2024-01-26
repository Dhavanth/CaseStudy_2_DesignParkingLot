package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {

    Long id = 0L;
    Map<Long, Vehicle> vehicles = new HashMap<>();

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        for(Vehicle vehicle : vehicles.values()){
            if(vehicle.getVehicleNumber().equals(vehicleNumber))
                return Optional.of(vehicle);
        }
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        vehicle.setId(id++);
        vehicles.put(vehicle.getId(), vehicle);

        return vehicle;
    }
}
