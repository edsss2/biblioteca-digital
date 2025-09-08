package com.edsonveiga.biblioteca_digital.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // A chave secreta deve ser, no mínimo, 32 bytes (256 bits) para HS256.
    // Recomendo gerar uma nova chave segura e manter aqui ou em um arquivo de configuração.
    // Exemplo de chave segura gerada e codificada em Base64:
    // private static final String SECRET_KEY = "sua-nova-chave-secreta-segura-e-longa-aqui-32bytes-em-base64";
    
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1h

    // Crie a chave uma única vez
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser() // <--- AQUI ESTÁ A MUDANÇA
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, String username) {
        try {
            String extractedUsername = extractUsername(token);
            return (extractedUsername.equals(username) && !isTokenExpired(token));
        } catch (JwtException e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser() // <--- E AQUI TAMBÉM
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}