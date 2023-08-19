package com.k1rard.apiservlet.webapp.headers.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {

    Optional<String> getUsername(HttpServletRequest req);
}
