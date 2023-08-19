package com.k1rard.apiservlet.webapp.headers.services;

import com.k1rard.apiservlet.webapp.headers.config.Service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@Service
public class LoginServiceSessionImpl implements LoginService{

    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        HttpSession session =  req.getSession();
        String username = (String) session.getAttribute("username");
        if(username != null){
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
