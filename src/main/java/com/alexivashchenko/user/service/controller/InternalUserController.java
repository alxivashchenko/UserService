package com.alexivashchenko.user.service.controller;

import com.alexivashchenko.user.service.dto.CreateUserProfileRequest;
import com.alexivashchenko.user.service.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/users")
public class InternalUserController {

    private final UserProfileService service;

    // INTERNAL — called by auth-service
    @PostMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createProfile(@RequestBody @Valid CreateUserProfileRequest request) {
        service.createProfile(request);
    }

}
