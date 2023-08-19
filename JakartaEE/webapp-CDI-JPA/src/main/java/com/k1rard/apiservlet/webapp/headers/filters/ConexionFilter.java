package com.k1rard.apiservlet.webapp.headers.filters;

import com.k1rard.apiservlet.webapp.headers.config.MysqlConn;
import com.k1rard.apiservlet.webapp.headers.services.ServiceJdbcException;
import com.k1rard.apiservlet.webapp.headers.util.ConexionBaseDatosDS;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Name;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {

    /*@Inject
    @MysqlConn
    private Connection conn;*/

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
   /*     try {
            Connection connRequest = this.conn;
            if(connRequest.getAutoCommit()){
                connRequest.setAutoCommit(false);
            }*/
            try{
//                servletRequest.setAttribute("conn", connRequest);
                filterChain.doFilter(servletRequest, servletResponse);
//                connRequest.commit();
            }catch (ServiceJdbcException ex){
//                connRequest.rollback();
                ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
     /*   } catch (SQLException e) {
            e.printStackTrace();
        } */
    }
}
