package com.k1rard.apiservlet.webapp.headers.repositories;

import jakarta.inject.Qualifier;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, CONSTRUCTOR, METHOD, PARAMETER, FIELD})
public @interface RepositoryJpa {
}
