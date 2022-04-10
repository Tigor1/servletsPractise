package ru.lid.servlet.service;

import lombok.Getter;
import ru.lid.servlet.dao.FlightDao;
import ru.lid.servlet.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private final FlightDao flightDao = FlightDao.getInstance();
    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {

    }

    public static FlightService getInstance() {
        return INSTANCE;
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> FlightDto.builder()
                                 .id( flight.getId())
                                .description("""
                        %s - %s - %s 
                        """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getFlightStatus()))
                        .build())
                .collect(Collectors.toList());
    }
}
