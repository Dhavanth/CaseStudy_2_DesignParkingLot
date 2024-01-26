package models;

import java.util.Date;

public class Ticket extends BaseModel{
    private String ticketNumber;
    private Vehicle vehicle;
    private ParkingSlot parkingSlotAssigned;
    private Date entrytime;
    private Operator operator;
    private Gate gate;

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlotAssigned() {
        return parkingSlotAssigned;
    }

    public void setParkingSlotAssigned(ParkingSlot parkingSlotAssigned) {
        this.parkingSlotAssigned = parkingSlotAssigned;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
