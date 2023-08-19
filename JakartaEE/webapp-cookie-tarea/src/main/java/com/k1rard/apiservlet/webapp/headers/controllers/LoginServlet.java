package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.services.LoginService;
import com.k1rard.apiservlet.webapp.headers.services.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USUARIO = "k1rard";
    final static  String PASSWORD = "12345";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        Optional<String> cookieOptional = auth.getUsername(req);

        if(cookieOptional.isPresent()){
            resp.setContentType("text/html; charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Hola" + cookieOptional.get() + "</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola " + cookieOptional.get() + " has iniciado session anteriormente</h1>");
                out.println("        <a href='" + req.getContextPath() +"/index.html'>Ir al inicio</a>");
                out.println("        <a href='" + req.getContextPath() +"/logout'>Cerrar Sesion</a>");
                out.println("    </body>");
                out.println("</html>");
            }
        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String usuario = req.getParameter("usuario");
            String password = req.getParameter("password");

            if(USUARIO.equals(usuario) && PASSWORD.equals(password)){
                Cookie usernameCookie = new Cookie("username", usuario);
                resp.addCookie(usernameCookie);
                resp.sendRedirect(req.getContextPath()+ "/login.html");
            }else{
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no autorizado para acceder a esta pagina");
            }
    }
}
