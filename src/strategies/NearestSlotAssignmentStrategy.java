package strategies;

import models.*;
import repositories.ParkingLotRepository;

public class NearestSlotAssignmentStrategy implements ParkingSlotAssignmentStrategy{

    ParkingLotRepository parkingLotRepository;

    public NearestSlotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public ParkingSlot getParkingSlot(Gate gate, VehicleType vehicleType) {
        ParkingLot parkingLot = parkingLotRepository.findByGate(gate);
        for(Floor floor: parkingLot.getFloors()){
            for(ParkingSlot parkingSlot: floor.getParkingSlots()){
                if(parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY) &&
                        parkingSlot.getVehicleTypesAllowed().contains(vehicleType))
                    return parkingSlot;
            }
        }
        return null;
    }
}
