package org.example.global.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.global.auth.user.CustomUserDetails;
import org.example.global.auth.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;


@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private SecretKey secretKey;
    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;

    @PostConstruct
    public void setSecretKey() {
        secretKey = new SecretKeySpec(jwtProperties.secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public String generateToken(CustomUserDetails userDetails) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+jwtProperties.expiration))
                .signWith(secretKey)
                .claim("username", userDetails.getUsername())
                .compact();
    }

    public Boolean isTokenExpired(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseClaimsJws(token).getPayload().getExpiration().before(new Date());
    }

    public String getUsername(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseClaimsJws(token).getPayload().get("username", String.class);
    }

    public Authentication getAuthentication(String token) {
        String user = getUsername(token);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(user);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    public String getToken(HttpServletRequest request) {
        String header = request.getHeader(jwtProperties.getHeader());

        if (header.startsWith(jwtProperties.getPerfix())) {
            return header.substring(jwtProperties.getPerfix().length());
        }

        return null;
    }
}
