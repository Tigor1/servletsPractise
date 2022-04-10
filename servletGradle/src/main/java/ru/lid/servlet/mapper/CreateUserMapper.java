package ru.lid.servlet.mapper;

import ru.lid.servlet.dto.CreateUserDto;
import ru.lid.servlet.entity.Gender;
import ru.lid.servlet.entity.Role;
import ru.lid.servlet.entity.User;
import ru.lid.servlet.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {
    private static final String IMAGE_FOLDER = "users/";
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getINSTANCE() {
        return INSTANCE;
    }
}
