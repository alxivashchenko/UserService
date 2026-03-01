package com.alexivashchenko.user.service.controller;

import com.alexivashchenko.user.service.dto.UpdateUserProfileRequest;
import com.alexivashchenko.user.service.dto.UserProfileResponse;
import com.alexivashchenko.user.service.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserProfileController {

    private final UserProfileService service;

    @GetMapping("/{id}")
    public UserProfileResponse getProfile(@PathVariable UUID id) {
        return service.getProfile(id);
    }

    @PutMapping("/{id}")
    public UserProfileResponse updateProfile(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateUserProfileRequest request
    ) {
        return service.updateProfile(id, request);
    }
}
