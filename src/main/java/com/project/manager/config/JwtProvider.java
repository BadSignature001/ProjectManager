package com.project.manager.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

	static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

	public static String generateToken(Authentication auth) {
		return Jwts.builder()
				.issuedAt(new Date())
				.expiration(new Date(new Date().getTime() + 24*60*60*1000 ))
				.claim("email", auth.getName())
				.signWith(key)
				.compact();

	}
	
	public static String getEmailFromToken(String jwt) {
		jwt = jwt.substring(7) ;
		
		Claims claims = Jwts
				.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(jwt)
				.getPayload();
		
		return String.valueOf(claims.get("email"));
	}



}
