package spring.springCinema.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.springCinema.decentralize.CustomUserDetails;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${springCinema.jwt.secret}")
    private String JWT_SECRET;

    @Value("${springCinema.jwt.secret}")
    private int JWT_EXPIRATION;

    // Generate Token from User:
    public String generateToken(CustomUserDetails customUserDetails) {
        Date now = new Date();
        Date expired = new Date(now.getTime() + JWT_EXPIRATION);

        // Generate JWT from username:
        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expired)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    // Get user information from JWT
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        // Return username information
        return claims.getSubject();
    }

    // Validate token:
    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException Ex) {
            log.error("Invalid JWT Token");
        } catch (ExpiredJwtException Ex) {
            log.error("Expired JWT Token");
        } catch (UnsupportedJwtException Ex) {
            log.error("Unsupported JWT Token");
        } catch (IllegalArgumentException Ex) {
            log.error("JWT Claims String is empty");
        }

        return false;
    }

}
