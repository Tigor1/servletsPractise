package ru.lid.servlet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Ticket {
    private Long id;
    private String passengerNo;
    private String getPassengerName;
    private Long flightId;
    private String seatNo;
    private BigDecimal cost;
}
