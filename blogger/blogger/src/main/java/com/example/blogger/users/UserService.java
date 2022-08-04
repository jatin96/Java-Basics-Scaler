package com.example.blogger.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UsersRepository usersRepository;
    private ModelMapper modelMapper;
    private UserJwtService userJwtService;

    public UserService(UsersRepository usersRepository, ModelMapper modelMapper, UserJwtService userJwtService) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.userJwtService = userJwtService;
    }

    public UserDTO.LoginUserResponse signupUser(UserDTO.CreateUserRequest user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        UserEntity savedUser = usersRepository.save(userEntity);
        UserDTO.LoginUserResponse response = modelMapper.map(savedUser, UserDTO.LoginUserResponse.class);
        response.setToken(userJwtService.createJwtToken(response.getUsername()));
        return response ;
    }

    public UserDTO.LoginUserResponse loginUser(UserDTO.LoginUserRequest user) {
        UserEntity userEntity;
        try {
            userEntity = usersRepository.findByUsername(user.getUsername());
        } catch(Exception e) {
            throw new UserNotFoundException(user.getUsername());
        }
        // TODO: Match passwords using hashing.
        if (userEntity.getPassword().equals(user.getPassword())) {
            UserDTO.LoginUserResponse response = modelMapper.map(userEntity, UserDTO.LoginUserResponse.class);
            response.setToken("token"); // TODO: generate token for logged in users.
            return response;
        } else {
            throw new UserAuthenticationException();
        }
    }

    public UserDTO.GetUserResponse getUserByUsername(String username) {
        UserEntity userEntity = usersRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException(username)
        );

        return modelMapper.map(userEntity, UserDTO.GetUserResponse.class);
    }



    static class UserAlreadyExistsException extends RuntimeException {
        public UserAlreadyExistsException(String message) {
            super(message);
        }
    }

    static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    static class UserAuthenticationException extends RuntimeException {
        public UserAuthenticationException() {

        }
    }


}
