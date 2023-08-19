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
import java.util.List;

@WebServlet("/cursos")
public class CursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursosService service = new CursoServiceJdbcImpl(conn);
        List<Curso> cursos = service.listar();
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/cursos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursosService service = new CursoServiceJdbcImpl(conn);
        String nombreCurso = req.getParameter("nombre");
        List<Curso> cursosFiltrados = service.buscarPorNombre(nombreCurso);
        List<Curso> cursos = service.listar();
        if(cursosFiltrados != null && !cursosFiltrados.isEmpty()){
            req.setAttribute("cursos", cursosFiltrados);
            getServletContext().getRequestDispatcher("/cursos.jsp").forward(req, resp);
        }else{
            req.setAttribute("cursos", cursos);
            getServletContext().getRequestDispatcher("/cursos.jsp").forward(req, resp);
        }
    }
}
