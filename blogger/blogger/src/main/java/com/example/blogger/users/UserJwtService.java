package com.example.blogger.users;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserJwtService {
    private static final String SECRET = "asdfaslasfasdfasdfasfasfasdf";
    private static final String USERNAME = "username";
    Algorithm algorithm = Algorithm.HMAC256(SECRET); // TODO: Use config to read values.

    public String createJwtToken(String username) {
        return JWT.create()
                .withClaim("username", username)
                .withIssuedAt(new Date()) // TODO: Add expiration.
                .sign(algorithm);
    }

    String getUserNameFromJwtToken(String jwtToken) {
        return JWT.require(algorithm)
                .build()
                .verify(jwtToken)
                .getClaim(USERNAME)
                .asString();
    }


}
