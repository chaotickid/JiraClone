package com.infinity.ticketmanagement.model.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketVM {

    @NotNull
    private String customerId;

    @NotNull
    private String assignedTo;

    @NotNull
    private String subject;

    @NotNull
    private String message;

}