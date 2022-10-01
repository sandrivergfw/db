package com.example.demo.utils;

import com.example.demo.entity.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreateJwt {
    public static String getToken(String username,int id){
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id+"")
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"my-123");
        System.out.println(jwtBuilder.compact());
        return jwtBuilder.compact();
    }
}
