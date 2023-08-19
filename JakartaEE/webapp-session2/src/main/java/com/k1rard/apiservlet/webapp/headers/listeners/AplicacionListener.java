package com.k1rard.apiservlet.webapp.headers.listeners;

import com.k1rard.apiservlet.webapp.headers.models.Carro;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AplicacionListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();
        servletContext.log("Inicializando la aplicacion");
        servletContext.setAttribute("mensaje", "Algun valor global de la app!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("Destruyendo la aplicacion");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Inicializando la Request");
        sre.getServletRequest().setAttribute("mensaje", "guardando valor para el request");
        sre.getServletRequest().setAttribute("title", "Catalogo Servlet ");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("Destruyendo la Request");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Creando la sesion");
        Carro carro = new Carro();
        HttpSession session = se.getSession();
        session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la sesion");
    }
}
