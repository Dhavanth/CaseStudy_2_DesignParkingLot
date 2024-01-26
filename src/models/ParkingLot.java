package models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<Floor> floors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;
    private FeeCalculatorStrategyType feeCalculatorStrategyType;

    public void setVehicleTypesAllowed(List<VehicleTypesAllowed> vehicleTypesAllowed) {
        this.vehicleTypesAllowed = vehicleTypesAllowed;
    }

    private List<VehicleTypesAllowed> vehicleTypesAllowed;
    private ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType;


    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public FeeCalculatorStrategyType getFeeCalculatorStrategyType() {
        return feeCalculatorStrategyType;
    }

    public void setFeeCalculatorStrategyType(FeeCalculatorStrategyType feeCalculatorStrategyType) {
        this.feeCalculatorStrategyType = feeCalculatorStrategyType;
    }

    public ParkingSlotAssignmentStrategyType getParkingSlotAssignmentStrategyType() {
        return parkingSlotAssignmentStrategyType;
    }

    public void setParkingSlotAssignmentStrategyType(ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType) {
        this.parkingSlotAssignmentStrategyType = parkingSlotAssignmentStrategyType;
    }
}
