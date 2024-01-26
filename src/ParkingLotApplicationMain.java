import controllers.TicketController;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;

public class ParkingLotApplicationMain {
    public static void main(String[] args) {

        // 1. Initialize repository
        // 2. Initialize services
        // 3. Initialize controllers

        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        // 4. Call controller methods

    }
}