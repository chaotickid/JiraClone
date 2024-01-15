package com.infinity.ticketmanagement.repository;

import com.infinity.ticketmanagement.model.document.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}