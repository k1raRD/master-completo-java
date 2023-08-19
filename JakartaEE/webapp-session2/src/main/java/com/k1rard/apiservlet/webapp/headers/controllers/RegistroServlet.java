package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.models.Usuario;
import com.k1rard.apiservlet.webapp.headers.services.UsuarioService;
import com.k1rard.apiservlet.webapp.headers.services.UsuarioServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioService service = new UsuarioServiceImpl((Connection) req.getAttribute("conn"));
        String username = req.getParameter("usuario");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password);
        service.crearUsuario(usuario);
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
