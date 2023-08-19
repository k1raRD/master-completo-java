package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.models.Factura;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/factura")
public class ProductosTareaServlet extends HttpServlet {
    @Inject
    private Factura factura;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("factura", factura);
        req.setAttribute("title", req.getAttribute("title") + " : Ejemplo factura con inyeccion de dependencias");

        getServletContext().getRequestDispatcher("/factura.jsp").forward(req, resp);
    }
}
