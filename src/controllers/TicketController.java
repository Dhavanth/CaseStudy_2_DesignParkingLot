package controllers;

import dto.IssueTicketRequestDto;
import dto.IssueTicketResponseDto;
import dto.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto){
        IssueTicketResponseDto ticketResponseDto = new IssueTicketResponseDto();
        try{
            Ticket ticket  = ticketService.issueTicket(requestDto.getVehicleNumber(),
                    requestDto.getVehicleOwner(),
                    requestDto.getVehicleType(),
                    requestDto.getGateId());
            ticketResponseDto.setTicket(ticket);
            ticketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }catch(Exception e){
            ticketResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }
        return ticketResponseDto;
    }
}
