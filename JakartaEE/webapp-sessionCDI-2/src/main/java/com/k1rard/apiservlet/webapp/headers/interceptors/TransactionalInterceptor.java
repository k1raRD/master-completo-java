package com.k1rard.apiservlet.webapp.headers.interceptors;

import com.k1rard.apiservlet.webapp.headers.config.MysqlConn;
import com.k1rard.apiservlet.webapp.headers.services.ServiceJdbcException;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.sql.Connection;
import java.util.logging.Logger;

@TransactionalJdbc
@Interceptor
public class TransactionalInterceptor {

    @Inject
    @MysqlConn
    private Connection conn;

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object transactional(InvocationContext invocation) throws Exception {
        if(conn.getAutoCommit()){
            conn.setAutoCommit(false);
        }
        try{
            logger.info(" ------> Iniciando transaction " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            Object resultado = invocation.proceed();
            conn.commit();
            logger.info(" ------> Finalizando transaction " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            return resultado;
        }catch (ServiceJdbcException e){
            conn.rollback();
            throw e;
        }

    }
}
