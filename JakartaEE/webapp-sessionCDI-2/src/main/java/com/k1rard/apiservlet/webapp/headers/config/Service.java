package com.k1rard.apiservlet.webapp.headers.config;

import com.k1rard.apiservlet.webapp.headers.interceptors.Logging;
import com.k1rard.apiservlet.webapp.headers.interceptors.TransactionalJdbc;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TransactionalJdbc
@Logging
@ApplicationScoped
@Stereotype
@Named
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
