package com.k1rard.apiservlet.webapp.headers.controllers;

import com.k1rard.apiservlet.webapp.headers.models.Curso;
import com.k1rard.apiservlet.webapp.headers.services.CursoServiceJdbcImpl;
import com.k1rard.apiservlet.webapp.headers.services.CursosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/curso/operacion")
public class CursoOperacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursosService service = new CursoServiceJdbcImpl(conn);
        Long id;
        try {
            id = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException ex) {
            id = 0L;
        }

        Curso curso = null;
        if (id != null & id > 0) {
            curso = service.buscarPorId(id);
            req.setAttribute("curso", curso);
            getServletContext().getRequestDispatcher("/cursoForm.jsp").forward(req, resp);
        } else {
            req.setAttribute("curso", curso);
            getServletContext().getRequestDispatcher("/cursoForm.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursosService service = new CursoServiceJdbcImpl(conn);
        Long id;
        try {
            id = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException ex) {
            id = 0L;
        }
        Boolean delete = Boolean.valueOf(req.getParameter("eliminar"));
        if(id > 0 && delete){
            service.eliminar(id);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        }else{
            String nombre = req.getParameter("nombre");
            String descripcion = req.getParameter("descripcion");
            String instructor = req.getParameter("instructor");
            Double duracion;
            try {
                duracion = Double.valueOf(req.getParameter("duracion"));
            } catch (NumberFormatException ex) {
                duracion = 0.0;
            }

            Curso curso = new Curso();
            curso.setId(id);
            curso.setNombre(nombre);
            curso.setDescripcion(descripcion);
            curso.setInstructor(instructor);
            curso.setDuracion(duracion);

            service.guardar(curso);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        }

    }
}
