package mapper;

import dto.CreateUserDto;
import entity.Role;
import entity.User;
import util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User>{

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
