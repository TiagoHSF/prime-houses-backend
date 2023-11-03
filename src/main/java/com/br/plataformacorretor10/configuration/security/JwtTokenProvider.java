package com.br.plataformacorretor10.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * The Class JwtTokenProvider
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
@Component
public class JwtTokenProvider {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UserDetails userDetails) throws Exception {
        try {
            final Date exp = new Date(System.currentTimeMillis() + ((long) 1000 * 60 * 60 * 24));
            final SignatureAlgorithm alg = SignatureAlgorithm.HS512;
            final String JWT = Jwts.builder()//
                .setSubject(userDetails.getUsername())//
                .setIssuedAt(new Date())//
                .setIssuer("TEST")//
                .setExpiration(exp)//
                .signWith(alg, secret).compact();
            return "Bearer" + " " +JWT;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String authToken) {
        try {
            //Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = customUserDetailService.loadUserByToken(token);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}