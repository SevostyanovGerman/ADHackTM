package com.adhack.adhack.repository;

import com.adhack.adhack.models.VkAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VkAccessTokenRepository extends JpaRepository<VkAccessToken, Long> {
}
