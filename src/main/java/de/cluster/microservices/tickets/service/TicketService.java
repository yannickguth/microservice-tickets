package de.cluster.microservices.tickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.cluster.microservices.tickets.model.Ticket;

@Service
public interface TicketService {
	
	List<Ticket> getTickets();
	
    public Ticket getTicket(String id);
     
    public void deleteTicket(String id);
  
    public String createTicket(Ticket t);
     
    public void updateTicket(Ticket t);
}