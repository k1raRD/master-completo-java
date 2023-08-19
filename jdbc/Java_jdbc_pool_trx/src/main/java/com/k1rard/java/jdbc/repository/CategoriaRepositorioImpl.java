package com.k1rard.java.jdbc.repository;

import com.k1rard.java.jdbc.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio<Categoria>{

    private Connection conn;

    public CategoriaRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public CategoriaRepositorioImpl() {
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categorias;")){
            while(rs.next()){
                Categoria categoria = createCategoria(rs);
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Integer id) throws SQLException {
        Categoria categoria = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categorias as c WHERE c.id = ?");){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery();){
                if(rs.next()){
                    categoria = createCategoria(rs);
                }
            }
        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sql = null;
        if(categoria.getId() != null && categoria.getId() > 0){
            sql = "UPDATE categorias SET nombre = ? WHERE id = ?";
        } else{
          sql = "INSERT INTO categorias (nombre) VALUES (?);";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, categoria.getNombre());
            if(categoria.getId() != null && categoria.getId() > 0){
                stmt.setInt(2, categoria.getId());
            }
            stmt.executeUpdate();

            if(categoria.getId() == null){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        categoria.setId(rs.getInt(1));
                    }
                }
            }
        }
        return categoria;
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement("DELETE FROM categorias WHERE id = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private static Categoria createCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("id"));
        categoria.setNombre(rs.getString("nombre"));
        return categoria;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
