package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    Map<Long, Ticket> tickets = new HashMap<>();
    Long id = 0L;
    public Ticket saveTicket(Ticket ticket){
        ticket.setId(id++);
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }
}
