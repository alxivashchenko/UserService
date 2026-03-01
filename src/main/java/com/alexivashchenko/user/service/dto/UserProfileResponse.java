package com.alexivashchenko.user.service.dto;

import java.time.Instant;
import java.util.UUID;

public record UserProfileResponse(
        UUID id,
        String email,
        String displayName,
        String avatarUrl,
        String timezone,
        Instant createdAt
) {}