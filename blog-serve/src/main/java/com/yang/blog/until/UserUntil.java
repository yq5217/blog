package com.yang.blog.until;

import com.yang.blog.security.configuration.TokenAuthenticationHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * Created by 2020/6/26
 *
 * @author yangyang
 */
public class UserUntil {

    private static final String SECRET_KEY = "ThisIsASpringSecurityDemo";

    public static String getUserByToken(String token){
        if (token != null){
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return (String)claims.get("sub");
        }
        return null;
    }

}
