package com.go.sports.config.security;

import com.go.sports.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${security.jwt.expiration}")
    private String expiration;

    @Value("${security.jwt.secret}")
    private String secret;

    public String getToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Date now  = new Date();
        Date dateExpiration = new Date(now.getTime() + Long.parseLong(expiration));
        return Jwts.builder().setIssuer("GO-SPORTS")
                .setSubject(user.getId())
                .setIssuedAt(now)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return claims.getSubject().toString();
    }

    public boolean isTokenValidated(String token){
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
