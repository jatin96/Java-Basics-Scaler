package com.example.blogger.users;

import com.example.blogger.common.ErrorDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    ResponseEntity<UserDTO.LoginUserResponse> signupUser(@RequestBody UserDTO.CreateUserRequest request) {
        UserDTO.LoginUserResponse response = userService.signupUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<UserDTO.LoginUserResponse> loginUser(@RequestBody UserDTO.LoginUserRequest request) {
        UserDTO.LoginUserResponse response = userService.loginUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/@{username}", produces = "application/json")
    ResponseEntity<UserDTO.GetUserResponse> getUser(@PathVariable("username") String username) {

        UserDTO.GetUserResponse response = userService.getUserByUsername(username);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler
    ResponseEntity<ErrorDTO> exceptionHandler(Exception e) {
        if (e instanceof UserService.UserNotFoundException) {
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.NOT_FOUND);
        }

        if(e instanceof UserService.UserAuthenticationException) {
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.UNAUTHORIZED);

        }

        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
