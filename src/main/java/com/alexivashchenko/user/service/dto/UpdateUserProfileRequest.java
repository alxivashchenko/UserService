package com.alexivashchenko.user.service.dto;

public record UpdateUserProfileRequest(
        String displayName,
        String avatarUrl,
        String timezone
) {}
