package asimo.v.entities.objects;

import asimo.v.entities.Event;
import asimo.v.entities.Sale;
import asimo.v.entities.Session;
import asimo.v.entities.User;
import asimo.v.entities.enums.TicketType;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class TicketObject {

    private String seat;

    @NotNull
    private TicketType ticketType;

    private Long price;

    @NotNull
    private String sessionIdentifier;

    @NotNull
    private String eventIdentifier;

    @NotNull
    private String localizationIdentifier;

    private String saleidentifier;

    private String useridentifier;

    @NotNull
    private Boolean occupied;
}
