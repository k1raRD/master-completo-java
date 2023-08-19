package com.k1rard.apiservlet.webapp.headers.config;

import com.k1rard.apiservlet.webapp.headers.models.LineaFactura;
import com.k1rard.apiservlet.webapp.headers.models.Producto;
import com.k1rard.apiservlet.webapp.headers.models.ProductoTarea;
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

import javax.naming.NamingException;
import javax.sound.sampled.Line;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
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
    private List<LineaFactura> beanLineas(){
        ProductoTarea producto1 = new ProductoTarea("Monitor LG LCD 23", 250);
        ProductoTarea producto2 = new ProductoTarea("Notebook Asus", 500);
        ProductoTarea producto3 = new ProductoTarea("Impresora HP Multifuncional", 800);
        ProductoTarea producto4 = new ProductoTarea("Escritorio Oficina", 300);

        LineaFactura linea1 = new LineaFactura(producto1, 2);
        LineaFactura linea2 = new LineaFactura(producto2, 2);
        LineaFactura linea3 = new LineaFactura(producto3, 3);
        LineaFactura linea4 = new LineaFactura(producto4, 2);

        return Arrays.asList(linea1, linea2, linea3, linea4);
    }
}
