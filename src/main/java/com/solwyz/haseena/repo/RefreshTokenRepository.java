package com.solwyz.haseena.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solwyz.haseena.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByUserId(Long userId);
}
