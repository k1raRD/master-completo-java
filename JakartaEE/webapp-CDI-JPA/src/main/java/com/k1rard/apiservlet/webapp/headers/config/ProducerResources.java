package com.k1rard.apiservlet.webapp.headers.config;

import com.k1rard.apiservlet.webapp.headers.util.JpaUtil;
import jakarta.annotation.Resource;
import jakarta.annotation.Resources;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@ApplicationScoped
public class ProducerResources {

    @Inject
    private Logger log;
    @Resource(name="jdbc/mysqlDB")
    private DataSource ds;

    @Produces
    @RequestScoped
//    @Named("conn")
    @MysqlConn
    private Connection beanConnection() throws NamingException, SQLException {
//        Context initContext = new InitialContext();
//        Context envContext = (Context) initContext.lookup("java:/comp/env");
//        DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB");
        return ds.getConnection();
    }

    @Produces
    private Logger beanLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    public void close(@Disposes @MysqlConn Connection conn) throws SQLException {
        conn.close();
        log.info("Cerrando la conexion a la bbdd mysql!");
    }

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager(){
        return JpaUtil.getEntityManager();
    }

    public void close(@Disposes EntityManager em){
        if(em.isOpen()){
            em.close();
            log.info("Cerrando la conexion del EntityManager");
        }
    }
}
