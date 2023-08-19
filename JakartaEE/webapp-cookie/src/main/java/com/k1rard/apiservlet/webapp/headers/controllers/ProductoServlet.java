package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.models.Producto;
import com.k1rard.apiservlet.webapp.headers.services.LoginService;
import com.k1rard.apiservlet.webapp.headers.services.LoginServiceImpl;
import com.k1rard.apiservlet.webapp.headers.services.ProductoServiceImpl;
import com.k1rard.apiservlet.webapp.headers.services.ProductosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductosService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceImpl();
        Optional<String> cookieOptional = auth.getUsername(req);
        resp.setContentType("text/html; charset=UTF-8");
        String servletPath = req.getServletPath();
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Listado de productos</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Listado de productos</h1>");
            if(cookieOptional.isPresent()){
                out.println("<div style='color: blue;'> " + cookieOptional.get() + " Bienvenido</div>");
            }
            out.println("         <table>");
            out.println("           <tr>");
            out.println("           <th>ID</th>");
            out.println("           <th>Nombre</th>");
            out.println("           <th>Tipo</th>");
            if(cookieOptional.isPresent()){
                out.println("           <th>Precio</th>");
            }
            out.println("           </tr>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                if(cookieOptional.isPresent()) {
                    out.println("<td>" + p.getPrecio() + "</td>");
                }
                out.println("</tr>");
            });
            out.println("         </table>");
            out.println("        <a href='" + req.getContextPath() +"/index.html'>Ir al inicio</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
