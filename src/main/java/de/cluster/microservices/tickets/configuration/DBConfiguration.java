package de.cluster.microservices.tickets.configuration;

import de.cluster.microservices.tickets.service.TicketServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DBConfiguration/* extends AbstractCouchbaseConfiguration*/ {

    @Autowired
    private TicketServiceImpl ticketService;


    @Bean
    public InitializingBean insert() {

        return new InitializingBean() {

            @Override
            public void afterPropertiesSet() {
                ticketService.createData();
            }

        };
    }

}