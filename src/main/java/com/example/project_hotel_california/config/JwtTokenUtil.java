package com.example.project_hotel_california.config;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtTokenUtil {
    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 6 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String secret;

    public String createToken(Long userId) {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            String token = JWT.create()
                    .withIssuer("hotel")
                    .withExpiresAt(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                    .withIssuedAt(new Date())
                    .withClaim("UserId", userId)
                    .sign(algorithm);
            return token;
    }

    public boolean isValidToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("hotel")
                    .build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception){
            return false;
        }
    }
}
