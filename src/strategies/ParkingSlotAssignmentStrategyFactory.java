package strategies;

import models.ParkingSlotAssignmentStrategyType;
import repositories.ParkingLotRepository;

public class ParkingSlotAssignmentStrategyFactory {

    private static ParkingLotRepository parkingLotRepository;

    public ParkingSlotAssignmentStrategyFactory(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    public static ParkingSlotAssignmentStrategy getParkingSlotAssignmentStrategy(ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType){
        if(parkingSlotAssignmentStrategyType == ParkingSlotAssignmentStrategyType.NEAREST_PARKING_SLOT){
            return new NearestSlotAssignmentStrategy(parkingLotRepository);
        }
        else if(parkingSlotAssignmentStrategyType == ParkingSlotAssignmentStrategyType.RANDOM_PARKING_SLOT){
            return new RandomSlotAssignmentStrategy();
        }
        return new NearestSlotAssignmentStrategy(parkingLotRepository);
    }

}
