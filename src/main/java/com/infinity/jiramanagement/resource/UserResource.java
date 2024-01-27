package com.infinity.jiramanagement.resource;

import com.infinity.jiramanagement.model.document.User;
import com.infinity.jiramanagement.model.view.JWTToken;
import com.infinity.jiramanagement.model.view.UserVM;
import com.infinity.jiramanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usermanagement")
@Slf4j
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody @Valid UserVM signUpRequest) {
        log.debug("User sign up requested =>");
        User systemUser1 = userService.addUser(signUpRequest);
        systemUser1.setPassword(null);
        log.debug("Successfully created user for email: {}", systemUser1.getEmail());
        return new ResponseEntity<>(systemUser1, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTToken> signIn(@RequestBody @Valid UserVM signInRequest) {
        log.debug("User sign in requested =>");
        return new ResponseEntity<>(userService.getUserDetails(signInRequest), HttpStatus.OK);
    }
}