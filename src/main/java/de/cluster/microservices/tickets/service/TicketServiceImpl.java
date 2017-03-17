package de.cluster.microservices.tickets.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.cluster.microservices.tickets.dao.TicketRepository;
import de.cluster.microservices.tickets.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TicketServiceImpl.class);

	@Autowired
	private TicketRepository ticketRepo;
	
	public void createData() {
		LOG.warn("/***USE FOR TESTS ONLY***/");
		LOG.info("creating tickets ");
		LOG.warn("/***USE FOR TESTS ONLY***/");
		try {
			if(getTickets().size() == 0) {
				createTicket(new Ticket("0", "Adesso Weihnachtsfeier", 35.95, new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse("19.12.2017"), 1500));
				createTicket(new Ticket("1", "Halloween Party", 18.95, new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse("31.10.2017"), 200));
				createTicket(new Ticket("2", "HS Bochum Abschlussfeier", 62.15, new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse("15.04.2017"), 55));
				createTicket(new Ticket("3", "Silvester Party", 89.99, new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN).parse("31.12.2017"), 5150));
			}
		} catch (Exception e) {
			LOG.error("Could not create Test Data");
		}
				
    }
	
	@Override
	public List<Ticket> getTickets() {
		return (List<Ticket>) ticketRepo.findAll();
	}
	
	@Override
	//@HystrixCommand
	public Ticket getTicket(String id) {
		return ticketRepo.findOne(id);
	}

	@Override
	//@HystrixCommand
	public void deleteTicket(String id) {
		ticketRepo.delete(id);		
	}

	@Override
	//@HystrixCommand
	public String createTicket(Ticket t) {
		return ticketRepo.save(t).getId();
	}

	@Override
	//@HystrixCommand
	public void updateTicket(Ticket t) { ticketRepo.save(t); }
	
	
	
}
