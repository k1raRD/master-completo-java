package com.k1rard.apiservlet.webapp.headers.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Logging
@Interceptor
public class LogginInterceptor {

    @Inject
    private Logger log;

    @AroundInvoke
    public Object logging(InvocationContext invocation) throws Exception {
        log.info(" ***** entrando antes de invocar al metodo " +
                invocation.getMethod().getName() + " de la clase " +
                invocation.getMethod().getDeclaringClass());
        log.info(" ***** Saliendo de la invocacion del metodo " +
                invocation.getMethod().getName());
        return invocation.proceed();
    }
}
