package com.infinity.ticketmanagement.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infinity.ticketmanagement.model.document.Ticket;
import com.infinity.ticketmanagement.model.view.TicketVM;
import com.infinity.ticketmanagement.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/ticketmanagement")
public class TicketResource {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/createTicket")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketVM ticketVM) throws JsonProcessingException {
        log.debug("Create ticket requested by customer id: {}", ticketVM.getCustomerId());
        Ticket createdTicket = ticketService.createTicket(ticketVM);
        log.debug("Ticket created successfully");
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

}