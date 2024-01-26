package strategies;

import models.Gate;
import models.ParkingSlot;
import models.VehicleType;

public interface ParkingSlotAssignmentStrategy {
    public ParkingSlot getParkingSlot(Gate gate, VehicleType vehicleType);
}
