package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.models.Carro;
import com.k1rard.apiservlet.webapp.headers.models.ItemCarro;
import com.k1rard.apiservlet.webapp.headers.models.Producto;
import com.k1rard.apiservlet.webapp.headers.services.ProductoServiceImpl;
import com.k1rard.apiservlet.webapp.headers.services.ProductosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/carro/ver")
public class VerCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", req.getAttribute("title") + ": Carro de compras");
        getServletContext().getRequestDispatcher("/carro.jsp").forward(req, resp);
    }
}
