package models;

import java.util.List;

public class ParkingSlot extends BaseModel{
    private ParkingSlotStatus parkingSlotStatus;
    private List<VehicleTypesAllowed> vehicleTypesAllowed;

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public List<VehicleTypesAllowed> getVehicleTypesAllowed() {
        return vehicleTypesAllowed;
    }

    public void setVehicleTypesAllowed(List<VehicleTypesAllowed> vehicleTypesAllowed) {
        this.vehicleTypesAllowed = vehicleTypesAllowed;
    }
}
