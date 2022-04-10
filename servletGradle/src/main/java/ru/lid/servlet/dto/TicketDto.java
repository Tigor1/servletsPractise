package ru.lid.servlet.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
public class TicketDto {
    Long id;
    Long flightId;
    String seatNo;
}
