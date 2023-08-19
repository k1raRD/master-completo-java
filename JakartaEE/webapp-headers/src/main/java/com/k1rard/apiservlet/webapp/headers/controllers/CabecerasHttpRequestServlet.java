package com.k1rard.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String metodoHttp = req.getMethod();
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr();
        String ipCliente = req.getRemoteAddr();
        int port = req.getLocalPort();
        String schema = req.getScheme();
        String host = req.getHeader("host");
        String  url = schema + "://" + host + contextPath + servletPath;
        String  url2 = schema + "://" + ip + ":" + port + contextPath + servletPath;
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Http Request</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Http Request</h1>");
            out.println("         <ul>");
            out.println("           <li>Metodo HTTP: " +  metodoHttp + "</li>");
            out.println("           <li>Request URI: " +  requestURI + "</li>");
            out.println("           <li>Request URL: " +  requestURL + "</li>");
            out.println("           <li>ContextPath: " +  contextPath + "</li>");
            out.println("           <li>ServletPath: " +  servletPath + "</li>");
            out.println("           <li>ip local: " +  ip + "</li>");
            out.println("           <li>ip Cliente: " +  ipCliente + "</li>");
            out.println("           <li>Puerto: " +  port + "</li>");
            out.println("           <li>Schema: " +  schema + "</li>");
            out.println("           <li>Host: " +  host + "</li>");
            out.println("           <li>url: " +  url + "</li>");
            out.println("           <li>url2: " +  url2 + "</li>");
            Enumeration<String> headerNames = req.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String cabecera = headerNames.nextElement();
                out.println("<li>" + cabecera + ": " +  req.getHeader(cabecera) + "</li>");
            }
            out.println("         </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
}
