/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author phani.y
 */
public class TokenAuthenticationService {

    private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
    private String secret = "ThisIsASecret";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";

    public void addAuthentication(HttpServletResponse response, Authentication user) {
        // We generate a token now.
        String JWT = Jwts.builder()
                .setSubject(user.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        response.addHeader(headerString, tokenPrefix + " " + JWT);
        response.addHeader("Access-Control-Allow-Origin", "**");
        addUser(response, user);
    }

    protected void addUser(HttpServletResponse response, Authentication user) {
        try {
            response.getWriter().print(new ObjectMapper().writeValueAsString(user));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerString);
        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            if (username != null) // we managed to retrieve a user
            {
                return new AuthenticatedUser(username);
            }
        }
        return null;
    }
}
