package com.k1rard.apiservlet.webapp.headers.filters;

import com.k1rard.apiservlet.webapp.headers.services.ServiceJdbcException;
import com.k1rard.apiservlet.webapp.headers.util.ConexionBaseDatosDS;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try(Connection conn = ConexionBaseDatosDS.getConexion()) {
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                servletRequest.setAttribute("conn", conn);
                filterChain.doFilter(servletRequest, servletResponse);
                conn.commit();
            }catch (SQLException | ServiceJdbcException ex){
                conn.rollback();
                ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
