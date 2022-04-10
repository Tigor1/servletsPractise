package ru.lid.servlet.dto;

import lombok.Builder;
import lombok.Value;
import ru.lid.servlet.entity.Gender;
import ru.lid.servlet.entity.Role;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    String image;
    LocalDate birthday;
    String mail;
    Role role;
    Gender gender;
}
