package com.alexivashchenko.user.service.service;

import com.alexivashchenko.user.service.dto.CreateUserProfileRequest;
import com.alexivashchenko.user.service.dto.UpdateUserProfileRequest;
import com.alexivashchenko.user.service.dto.UserProfileResponse;
import com.alexivashchenko.user.service.entity.UserProfile;
import com.alexivashchenko.user.service.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository repository;

    public void createProfile(CreateUserProfileRequest request) {

        if (repository.existsById(request.userId())) {
            return; // idempotent
        }

        UserProfile profile = UserProfile.builder()
                .id(request.userId())
                .email(request.email())
                .displayName(request.email())
                .build();

        repository.save(profile);
    }

    public UserProfileResponse getProfile(UUID id) {

        UserProfile profile = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return map(profile);
    }

    public UserProfileResponse updateProfile(UUID id, UpdateUserProfileRequest request) {

        UserProfile profile = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        profile.setDisplayName(request.displayName());
        profile.setAvatarUrl(request.avatarUrl());
        profile.setTimezone(request.timezone());

        repository.save(profile);

        return map(profile);
    }

    private UserProfileResponse map(UserProfile p) {
        return new UserProfileResponse(
                p.getId(),
                p.getEmail(),
                p.getDisplayName(),
                p.getAvatarUrl(),
                p.getTimezone(),
                p.getCreatedAt()
        );
    }
}
