package com.example.milad.demo.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService {

    private val secretKey: SecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)

    fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .signWith(secretKey)
            .compact() // لا يوجد وقت انتهاء هنا (توكن دائم)
    }

    fun extractUsername(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }
}
