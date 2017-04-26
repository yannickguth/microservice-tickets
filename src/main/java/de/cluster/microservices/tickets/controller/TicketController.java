package de.cluster.microservices.tickets.controller;

import de.cluster.microservices.tickets.model.Ticket;
import de.cluster.microservices.tickets.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RestController
public class TicketController {

    private static Logger LOG = LoggerFactory.getLogger(TicketController.class);

	 @Autowired
	 private TicketService ticketService;
	
	
	/**
     * create ticket
     *
     */
    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public ResponseEntity<String> createTicket(
        @RequestBody Ticket ticket) {
        String id = ticketService.createTicket(ticket);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
    
    /**
     * update ticket
     */
    @RequestMapping(value = "/tickets", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTicket(@RequestBody Ticket ticket) {
        ticketService.updateTicket(ticket);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }
     
    /**
     * delete ticket
     */
    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTicket(@PathVariable String id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }
    
    /**
     * ticket by id
     */
    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ticket> getTicketById(
        @PathVariable String id) {
        LOG.info("* get ticket by id *");
        Ticket t = ticketService.getTicket(id);
        if(t == null) {
            return new ResponseEntity<>((Ticket) null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(t,HttpStatus.OK);
    }
    
    /**
     * get all tickets
     */
    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public ResponseEntity<List<Ticket>> getTickets() {
        LOG.info("* get all tickets *");
		List<Ticket> tickets = ticketService.getTickets();
		ResponseEntity<List<Ticket>> tRes = new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
		return tRes;
 	}
	
	
	     

}
