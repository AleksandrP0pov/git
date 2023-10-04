package service;
import dto.UserDto;
import mapper.UserMapper;
import validator.Error;
import dao.UserDao;
import dto.CreateUserDto;
import entity.User;
import excaption.ValidationException;
import lombok.NoArgsConstructor;
import mapper.CreateUserMapper;
import validator.CreateUserValidator;
import validator.ValidationResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = new UserDao();
    private final UserMapper userMapper = UserMapper.getInstance();


    public Integer create(CreateUserDto userDto) {
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }
        User userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
}
    public Optional<UserDto> login(String email, String password){
        return userDao.findByEmailAndPassword(email,password)
                .map(userMapper::mapFrom);
    }

    public List<UserDto> findAll(){
        return userDao.findAll().stream()
                .map(user -> UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .birthday(user.getBirthday())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .role(user.getRole())
                        .build()
                ).collect(Collectors.toList());
    }



    public static UserService getInstance(){
        return INSTANCE;
    }
}
