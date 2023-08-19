package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.models.Usuario;
import com.k1rard.apiservlet.webapp.headers.services.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    @Inject
    private UsuarioService service;
    @Inject
    private LoginService auth;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> usernameOptional = auth.getUsername(req);

        if(usernameOptional.isPresent()){
            resp.setContentType("text/html; charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Hola" + usernameOptional.get() + "</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola " + usernameOptional.get() + " has iniciado session anteriormente</h1>");
                out.println("        <a href='" + req.getContextPath() +"/index.jsp'>Ir al inicio</a>");
                out.println("        <a href='" + req.getContextPath() +"/logout'>Cerrar Sesion</a>");
                out.println("    </body>");
                out.println("</html>");
            }
        }else{
            req.setAttribute("title", req.getAttribute("title") + ": Login");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String usuario = req.getParameter("usuario");
            String password = req.getParameter("password");

            Optional<Usuario> optionalUsuario = service.login(usuario, password);
            if(optionalUsuario.isPresent()){
                HttpSession session = req.getSession();
                session.setAttribute("username", usuario);
                resp.sendRedirect(req.getContextPath()+ "/login.html");
            }else{
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no autorizado para acceder a esta pagina");
            }
    }
}
