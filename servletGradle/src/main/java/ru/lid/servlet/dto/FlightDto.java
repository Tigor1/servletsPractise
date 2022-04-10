package ru.lid.servlet.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;


@Value
@Builder
public class FlightDto {
    Long id;
    String description;
}
