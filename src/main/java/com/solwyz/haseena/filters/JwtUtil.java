//package com.solwyz.haseena.filters;
//
//
//import java.util.Base64;
//import java.util.Date;
//
//import javax.crypto.SecretKey;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//@Component
//public class JwtUtil {
//
//	private final SecretKey secretKey;
//
//    // Inject secret from application.properties
//    public JwtUtil(@Value("${app.token.secret}") String secret) {
//        byte[] keyBytes = Base64.getDecoder().decode(secret);
//        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    // Generate JWT using only email
//    public String generateToken(String email) {
//        return Jwts.builder()
//                .setSubject(email)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
//                .signWith(secretKey, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    // Validate token against email
//    public boolean validateToken(String token, String email) {
//        String username = extractUsername(token);
//        return (username.equals(email) && !isTokenExpired(token));
//    }
//
//    // Extract email from token (stored as subject)
//    public String extractUsername(String token) {
//        return extractClaims(token).getSubject();
//    }
//
//    // Check token expiration
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return extractClaims(token).getExpiration();
//    }
//
//    // Get all claims
//    private Claims extractClaims(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(secretKey)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}
