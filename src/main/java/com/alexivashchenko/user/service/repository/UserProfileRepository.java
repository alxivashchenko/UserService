package com.alexivashchenko.user.service.repository;

import com.alexivashchenko.user.service.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
}