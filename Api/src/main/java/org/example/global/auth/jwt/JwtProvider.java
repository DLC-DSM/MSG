package org.example.global.auth.jwt;

import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    @Value("${spring.jwt.secret}")
    private String secret;
    private SecretKey secretKey;
    private static final long ACCESS_TOKEN_VALIDITY_SECONDS = 1000 * 60 * 10;
    private static final long REFRESH_TOKEN_VALIDITY_SECONDS = 1000 * 60 * 60 * 24 * 7;

    @PostConstruct
    public void getSecretKey() {
        secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public String generateAccessToken(Authentication authentication) {
        return generateToken(authentication,ACCESS_TOKEN_VALIDITY_SECONDS);
    }

    public String generateRefreshToken(Authentication authentication) {
        
    }

    private String generateToken(Authentication authentication, long expireTime) {
        Date date = new Date(System.currentTimeMillis());
        Date expireDate = new Date(date.getTime() + expireTime);

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());

        return Jwts.builder()
                .subject(authentication.getName())
                .claim("ROLES",authorities)
                .issuedAt(date)
                .expiration(expireDate)
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }
}
