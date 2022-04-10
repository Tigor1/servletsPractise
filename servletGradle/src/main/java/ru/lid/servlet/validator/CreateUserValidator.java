package ru.lid.servlet.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.lid.servlet.dto.CreateUserDto;
import ru.lid.servlet.entity.Gender;
import ru.lid.servlet.entity.Role;
import ru.lid.servlet.util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (Gender.find(object.getGender()).isEmpty()) {
            validationResult.add(Error.of("Invalid gender", "Gender is invalid"));
        }
        if (Role.find(object.getRole()).isEmpty()) {
            validationResult.add((Error.of("Invalid role", "Role is invalid")));
        }
        return validationResult;
    }

    public static CreateUserValidator getINSTANCE() {
        return INSTANCE;
    }
}
