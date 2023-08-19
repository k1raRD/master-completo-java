package com.k1rard.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    final static String USUARIO = "k1rard";
    final static  String PASSWORD = "12345";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String usuario = req.getParameter("usuario");
            String password = req.getParameter("password");

            if(USUARIO.equals(usuario) && PASSWORD.equals(password)){
                resp.setContentType("text/html; charset=UTF-8");
                try (PrintWriter out = resp.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("    <head>");
                    out.println("        <meta charset=\"UTF-8\">");
                    out.println("        <title>Login Correcto</title>");
                    out.println("    </head>");
                    out.println("    <body>");
                    out.println("        <h1>Login Correcto</h1>");
                    out.println("        <h1>Hola" + usuario + " has iniciado sesion con exito!</h1>");
                    out.println("    </body>");
                    out.println("</html>");
                }
            }else{
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no autorizado para acceder a esta pagina");
            }
    }
}
