package com.k1rard.apiservlet.webapp.headers.repositories;

import com.k1rard.apiservlet.webapp.headers.config.MysqlConn;
import com.k1rard.apiservlet.webapp.headers.config.Repository;
import com.k1rard.apiservlet.webapp.headers.models.Curso;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepositoryJdbcImpl implements CursoRepository{

    @Inject
    @MysqlConn
    private Connection conn;

    @Override
    public List<Curso> listar() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cursos c");){
            while(rs.next()){
                Curso curso = getCurso(rs);
                cursos.add(curso);
            }
        }
        return cursos;
    }

    @Override
    public List<Curso> buscarPorNombre(String nombre) throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos AS c WHERE c.nombre LIKE ? ")){
            stmt.setString(1, "%" + nombre + "%");
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                   Curso curso = getCurso(rs);
                    cursos.add(curso);
                }
            }
        }
        return cursos;
    }

    @Override
    public Curso porId(Long id) throws SQLException {
        Curso curso = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos AS c WHERE c.id = ? ")){
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    curso = getCurso(rs);
                }
            }
        }
        return curso;
    }

    @Override
    public void guardar(Curso curso) throws SQLException {
        String sql;
        if(curso.getId() != null && curso.getId() > 0){
            sql = "UPDATE cursos SET nombre=?, descripcion=?, instructor=?, duracion=? WHERE id = ?;";
        }else{
            sql = "INSERT INTO cursos (nombre, descripcion, instructor, duracion) VALUES(?,?,?,?);";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, curso.getNombre());
            stmt.setString(2, curso.getDescripcion());
            stmt.setString(3, curso.getInstructor());
            stmt.setDouble(4, curso.getDuracion());
            if(curso.getId() != null && curso.getId() > 0){
                stmt.setLong(5, curso.getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM cursos WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private static Curso getCurso(ResultSet rs) throws SQLException {
        Curso curso = new Curso();
        curso.setId(rs.getLong("id"));
        curso.setNombre(rs.getString("nombre"));
        curso.setDescripcion(rs.getString("descripcion"));
        curso.setInstructor(rs.getString("instructor"));
        curso.setDuracion(rs.getDouble("duracion"));
        return curso;
    }
}
