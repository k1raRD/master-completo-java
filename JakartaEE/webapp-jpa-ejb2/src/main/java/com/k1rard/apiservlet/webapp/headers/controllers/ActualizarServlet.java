package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.config.ProductoServicePrincipal;
import com.k1rard.apiservlet.webapp.headers.models.Carro;
import com.k1rard.apiservlet.webapp.headers.models.ItemCarro;
import com.k1rard.apiservlet.webapp.headers.models.entities.Producto;
import com.k1rard.apiservlet.webapp.headers.services.ProductosService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/carro/actualizar")
public class ActualizarServlet extends HttpServlet {
    @Inject
    private Carro carro;
    @Inject
    @ProductoServicePrincipal
    private ProductosService service;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Producto> producto = service.buscarPorId(id);
//        HttpSession session = req.getSession();
//        Carro carro = (Carro) session.getAttribute("carro");
        carro.removeItem(new ItemCarro(1, producto.get()));
//        session.setAttribute("carro", carro);
        resp.sendRedirect(req.getContextPath() + "/carro.jsp");
    }
}
