package com.k1rard.webpp.ejb.controllers;

import com.k1rard.webpp.ejb.models.Producto;
import com.k1rard.webpp.ejb.service.ServiceEjb;
import com.k1rard.webpp.ejb.service.ServiceEjbLocal;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

//    @Inject
//    private ServiceEjbLocal service;
//
//    @Inject
//    private ServiceEjbLocal service2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceEjbLocal service = null;
        ServiceEjbLocal service2 = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!com.k1rard.webpp.ejb.service.ServiceEjbLocal");
            service2 = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!com.k1rard.webpp.ejb.service.ServiceEjbLocal");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("service si es igual a service2 = " + service.equals(service2));

        Producto p = service.crear(new Producto("uvas"));
        System.out.println("Nuevo producto " + p);
        req.setAttribute("saludo", service.saludar("Alex"));
        req.setAttribute("saludo2", service2.saludar("Mario"));
        req.setAttribute("listado", service.listar());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
