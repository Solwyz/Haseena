package com.solwyz.haseena.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.haseena.entity.RefreshToken;
import com.solwyz.haseena.repo.RefreshTokenRepository;

@Service
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepo;

    public RefreshToken createRefreshToken(Long userId) {
        RefreshToken token = new RefreshToken();
        token.setUserId(userId);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Instant.now().plus(7, ChronoUnit.DAYS));
        return refreshTokenRepo.save(token);
    }
}

//import java.util.Date;
//import java.util.Optional;
//import java.util.UUID;
// 
//
// 
//import org.apache.commons.lang3.time.DateUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.solwyz.haseena.repo.UserRepository;
// 
//@Service
//public class RefreshTokenService {
// 
//	@Value("${app.jwtRefreshExpirationMs}")
//	private Long refreshTokenDurationMs;
// 
//	@Autowired
//	private RefreshTokenRepository refreshTokenRepository;
// 
//	@Autowired
//	private UserRepository userRepository;
// 
//	public Optional<RefreshToken> findByToken(String token) {
//		return refreshTokenRepository.findByToken(token);
//	}
// 
//	public RefreshToken createRefreshToken(UUID userId) {
//		RefreshToken refreshToken = new RefreshToken();
// 
//		refreshToken.setUser(userRepository.findById(userId).get());
//		Date expDate = DateUtils.addMilliseconds(new Date(), refreshTokenDurationMs.intValue());
//		refreshToken.setExpiryDate(expDate);
//		refreshToken.setToken(UUID.randomUUID().toString());
// 
//		refreshToken = refreshTokenRepository.save(refreshToken);
//		return refreshToken;
//	}
// 
//	public RefreshToken verifyExpiration(RefreshToken token) {
//		if (token.getExpiryDate().compareTo(new Date()) < 0) {
//			refreshTokenRepository.delete(token);
//			throw new TokenRefreshException(token.getToken(),
//					"Refresh token was expired. Please make a new signin request");
//		}
// 
//		return token;
//	}
// 
//	@Transactional
//	public int deleteByUserId(UUID userId) {
//		return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
//	}
// 
//}