package com.ncuhome.startmeet.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

/*
* 解析token
* */
@Slf4j
public class Token {
    private static String apiKey = "star00star";
    public static boolean parseJWT(String jwt) {
        try {
            Jwts.parser().setSigningKey(apiKey.getBytes("UTF-8")).parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;//解析成功则返回true
    }

    public static Object getInfo(String jwt, String key) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(apiKey.getBytes("UTF-8"))
                    .parseClaimsJws(jwt).getBody();
            return claims.get(key);
        } catch (Exception e) {
            return null;
        }
    }
}
