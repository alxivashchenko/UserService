package com.alexivashchenko.user.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateUserProfileRequest(
        @NotNull UUID userId,
        @Email String email
) {}