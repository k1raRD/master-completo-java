package com.k1rard.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class getParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter out = resp.getWriter();

      String saludo = req.getParameter("saludo");
      String nombre = req.getParameter("nombre");
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("    <head>");
      out.println("        <meta charset=\"UTF-8\">");
      out.println("        <title></title>");
      out.println("    </head>");
      out.println("    <body>");
      out.println("        <h1></h1>");
      if(saludo != null && nombre != null){
        out.println("        <h2>El saludo enviados es: " + saludo + " " + nombre  + " "+ "</h2>");
      } else if (saludo != null) {
        out.println("        <h2>El saludo enviados es: " + saludo + "</h2>");
      } else if (nombre != null) {
        out.print("<h2>Solo se ha pasado el nombre: " + nombre);
      } else{
        out.print("<h2> No se han pasado ninguno de los parametros saludo o nombre");
      }
      try{
        Integer codigo = Integer.parseInt(req.getParameter("codigo"));
        out.println("<h3>El codigo enviado es: " + codigo + "</h3>");
      }catch (NumberFormatException ex){
        ex.printStackTrace(System.out);
        out.println("<h3>No se paso ningun codigo</h3>");
      }
      out.println("    </body>");
      out.println("</html>");
      out.close();
    }
}
