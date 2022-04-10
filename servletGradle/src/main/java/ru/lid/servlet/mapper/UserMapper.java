package ru.lid.servlet.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.lid.servlet.dto.UserDto;
import ru.lid.servlet.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<User, UserDto> {

    private static final UserMapper INSTANCE = new UserMapper();

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .birthday(object.getBirthday())
                .mail(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static UserMapper getINSTANCE() {
        return INSTANCE;
    }
}
