package com.et.backend.application.auth.util;

import com.et.user.application.service.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;


@Component
public class JwtUtil {

    private static final long TOKEN_VALIDITY_IN_MS = 60 * 60 * 1000;
    private static final long TIMESTAMP = System.currentTimeMillis();

    private static final String SECRET = "secret";

    public String generateJWTToken(UserDto userDto){
        return Jwts.builder()
                .setIssuedAt(new Date(TIMESTAMP))
                .setIssuer("expense-tracker.io")
                .claim("userId", userDto.getUserId())
                .claim("username", userDto.getUsername())
                .setExpiration(new Date(TIMESTAMP + TOKEN_VALIDITY_IN_MS))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public boolean validateJWTToken(String token){
        return getUsername(token) != null && isExpired(token);
    }

    private boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.get("username").toString();
    }
    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    public UUID getUserIdFromJWTToken(String token){
        return UUID.fromString(getClaims(token).get("userId").toString());
    }
}
