package com.infinity.ticketmanagement.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinity.common.model.MetaData;
import com.infinity.ticketmanagement.config.TicketConfig;
import com.infinity.ticketmanagement.constant.TicketConstants;
import com.infinity.ticketmanagement.constant.TicketStatus;
import com.infinity.ticketmanagement.model.document.Ticket;
import com.infinity.ticketmanagement.model.view.TicketVM;
import com.infinity.ticketmanagement.repository.TicketRepository;
import com.infinity.usermanagement.model.document.User;
import com.infinity.usermanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Slf4j
@Service
public class TicketService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TicketConfig ticketConfig;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(TicketVM ticketVM) throws JsonProcessingException {
        log.debug("Incoming request for ticket creation is: {}", objectMapper.writeValueAsString(ticketVM));
        User user = userService.getUserById(ticketVM.getCustomerId());
        Ticket newTicket = new Ticket();
        newTicket.setAssignedTo(ticketVM.getAssignedTo());
        newTicket.setReportsTo(user.getEmail());
        newTicket.setSubject(ticketVM.getSubject());
        newTicket.setMessage(ticketVM.getMessage());

        //meta data
        MetaData metaData = new MetaData();
        metaData.setCreatedAt(String.valueOf(Instant.now()));
        metaData.setUpdatedAt(String.valueOf(Instant.now()));
        metaData.setType(TicketConstants.TICKET);
        metaData.setStatus(String.valueOf(TicketStatus.OPEN));
        newTicket.setMetaData(metaData);
        log.debug("Created a new ticket: {}", objectMapper.writeValueAsString(newTicket));

        return ticketRepository.save(newTicket);
    }


//    private String addTicketToReferenceList() {
//        Optional<TicketReferenceList> ticketReferenceList = ticketReferenceListMaintainer.findById("TicketReferenceList");
//        if (ticketReferenceList.isPresent()) {
//            log.debug("TicketReferenceList document is present, fetching latest id =>");
//            TicketReferenceList fetchedOptional = ticketReferenceList.get();
//            int latestId = Integer.parseInt(fetchedOptional.getLatestCount()) + 1;
//            fetchedOptional.setLatestCount(String.valueOf(latestId));
//            ticketReferenceListMaintainer.save(fetchedOptional);
//            log.debug("Latest id for user: {}", latestId);
//            return String.valueOf(ticketConfig.getClassIdValue() + Constants.DOUBLE_COLON + latestId);
//        }
//        log.debug("TicketReferenceList document is not present, saving new document for TicketReferenceList and " +
//                "setting default values");
//        TicketReferenceList ticketReferenceList1 = new TicketReferenceList();
//        ticketReferenceList1.setLatestCount(ticketConfig.getInitialValue());
//        log.debug("final document of reference list: {} and returning default value as 1000", ticketReferenceList1);
//        ticketReferenceListMaintainer.save(ticketReferenceList1);
//        return ticketConfig.getClassIdValue() + Constants.DOUBLE_COLON + ticketConfig.getInitialValue();
//    }


}