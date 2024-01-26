package services;

import dto.IssueTicketRequestDto;
import exceptions.GateNotFoundException;
import exceptions.VehicleNotFoundException;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.ParkingSlotAssignmentStrategy;
import strategies.ParkingSlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
                              String vehicleOwner,
                              VehicleType vehicleType,
                              Long gateId) throws GateNotFoundException, VehicleNotFoundException {

        Ticket ticket = new Ticket();
        // ENTRY TIME
        ticket.setEntrytime(new Date());

        // GATE
        Optional<Gate> optionalGate = gateRepository.findByGateId(gateId);
        if(!optionalGate.isPresent())
            throw new GateNotFoundException("Gate not found");
        Gate gate = optionalGate.get();
        ticket.setGate(gate);

        // VEHICLE
        Vehicle savedVehicle;
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if(!optionalGate.isPresent()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setNameOfOwner(vehicleOwner);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }else{
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        // OPERATOR
        ticket.setOperator(gate.getOperator());

        // OPERATOR
        ticket.setTicketNumber("Ticket Number " + new Random().nextInt());

        // PARKING SLOT ASSIGNMENT
        ParkingSlotAssignmentStrategyType parkingSlotAssignmentStrategyType = parkingLotRepository.findByGate(gate).getParkingSlotAssignmentStrategyType();
        ParkingSlotAssignmentStrategy parkingSlotAssignmentStrategy = ParkingSlotAssignmentStrategyFactory.getParkingSlotAssignmentStrategy(parkingSlotAssignmentStrategyType);
        ParkingSlot parkingSlot = parkingSlotAssignmentStrategy.getParkingSlot(gate, vehicleType);
        ticket.setParkingSlotAssigned(parkingSlot);

        ticketRepository.saveTicket(ticket);

        return ticket;
    }
}
