package mapper;

import dto.UserDto;
import entity.User;

public class UserMapper implements Mapper<User, UserDto> {
    private static final UserMapper INSTANCE = new UserMapper();
    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .role(object.getRole())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
