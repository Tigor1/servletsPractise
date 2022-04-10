package ru.lid.servlet.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import ru.lid.servlet.dao.UserDao;
import ru.lid.servlet.dto.CreateUserDto;
import ru.lid.servlet.dto.UserDto;
import ru.lid.servlet.entity.User;
import ru.lid.servlet.exception.ValidationException;
import ru.lid.servlet.mapper.CreateUserMapper;
import ru.lid.servlet.mapper.UserMapper;
import ru.lid.servlet.validator.CreateUserValidator;
import ru.lid.servlet.validator.ValidationResult;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final UserDao userDao = new UserDao();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getINSTANCE();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getINSTANCE();
    private final ImageService imageService = ImageService.getINSTANCE();
    private final UserMapper userMapper = UserMapper.getINSTANCE();


    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    public List<User> getAll() {
        return userDao.findAll();
    }

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
        //validation
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        //map
        var userEntity = createUserMapper.mapFrom(userDto);

        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        //userDao.save
        userDao.save(userEntity);
        //return id
        return userEntity.getId();
    }



    public static UserService getINSTANCE() {
        return INSTANCE;
    }
}
