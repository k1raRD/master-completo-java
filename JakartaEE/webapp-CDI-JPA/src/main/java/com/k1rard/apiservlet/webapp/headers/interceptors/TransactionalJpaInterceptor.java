package com.k1rard.apiservlet.webapp.headers.interceptors;

import com.k1rard.apiservlet.webapp.headers.config.MysqlConn;
import com.k1rard.apiservlet.webapp.headers.services.ServiceJdbcException;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;

import java.sql.Connection;
import java.util.logging.Logger;

@TransactionalJpa
@Interceptor
public class TransactionalJpaInterceptor {

    @Inject
    private EntityManager em;

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object transactional(InvocationContext invocation) throws Exception {
        try{
            logger.info(" ------> Iniciando transaction " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            em.getTransaction().begin();
            Object resultado = invocation.proceed();
            em.getTransaction().commit();
            logger.info(" ------> Finalizando transaction " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            return resultado;
        }catch (ServiceJdbcException e){
            em.getTransaction().rollback();
            throw e;
        }

    }
}
