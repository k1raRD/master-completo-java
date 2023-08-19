package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.config.ProductoServicePrincipal;
import com.k1rard.apiservlet.webapp.headers.models.Producto;
import com.k1rard.apiservlet.webapp.headers.services.ProductoServiceJdbcImpl;
import com.k1rard.apiservlet.webapp.headers.services.ProductosService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/productos/eliminar")
public class ProductoEliminarServlet extends HttpServlet {
    @Inject
    @ProductoServicePrincipal
    private ProductosService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        try{
            id = Long.valueOf(req.getParameter("id"));
        }catch (NumberFormatException ex){
            id = 0L;
        }
        if(id > 0){
            Optional<Producto> o = service.buscarPorId(id);
            if(o.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/productos");
            }else{
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el producto que desea eliminar!");
            }
        }else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Debe elegir un producto a eliminar!");
        }
    }
}
