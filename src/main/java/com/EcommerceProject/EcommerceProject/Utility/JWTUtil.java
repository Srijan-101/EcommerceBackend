package com.EcommerceProject.EcommerceProject.Utility;


import com.EcommerceProject.EcommerceProject.Exception.AppException;
import com.EcommerceProject.EcommerceProject.Repository.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JWTUtil {
    private final UserRepository userRepository;
    private final String secret = "3hJ7mKpFqRtUwXyZaB8cVnE9x1i2g4o5N6l0sPdWfG";

    public String generateToken(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        com.EcommerceProject.EcommerceProject.Model.User databaseUser =
                userRepository.getUserByEmail(principal.getUsername());

        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() * 864000000);

        return Jwts.builder()
                .setSubject(principal.getUsername())
                .claim("Id",databaseUser.getId())
                .claim("Role",databaseUser.getRole())
                .claim("Email",databaseUser.getEmail())
                .claim("FirstName",databaseUser.getFirstName())
                .claim("LastName",databaseUser.getLastName())
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(secret.getBytes());
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
             throw new AppException("Invalid JWT token", HttpStatus.BAD_REQUEST);
        } catch (ExpiredJwtException ex) {
             System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
             System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
             System.out.println("JWT claims string is empty.");
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                  .build().parseClaimsJws(token).getBody();
          return claims.getSubject();
    }
}
