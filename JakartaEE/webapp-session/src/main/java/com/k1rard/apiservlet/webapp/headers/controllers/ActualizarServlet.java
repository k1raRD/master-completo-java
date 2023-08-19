package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.models.Carro;
import com.k1rard.apiservlet.webapp.headers.models.ItemCarro;
import com.k1rard.apiservlet.webapp.headers.models.Producto;
import com.k1rard.apiservlet.webapp.headers.services.ProductoServiceJdbcImpl;
import com.k1rard.apiservlet.webapp.headers.services.ProductosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/carro/actualizar")
public class ActualizarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductosService service = new ProductoServiceJdbcImpl(conn);
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Producto> producto = service.buscarPorId(id);
        HttpSession session = req.getSession();
        Carro carro = (Carro) session.getAttribute("carro");
        carro.removeItem(new ItemCarro(1, producto.get()));
        session.setAttribute("carro", carro);
        resp.sendRedirect(req.getContextPath() + "/carro.jsp");
    }
}
