package com.k1rard.apiservlet.webapp.headers.repositories;

import com.k1rard.apiservlet.webapp.headers.config.MysqlConn;
import com.k1rard.apiservlet.webapp.headers.config.Repository;
import com.k1rard.apiservlet.webapp.headers.models.Usuario;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{

    @Inject
    @MysqlConn
    private Connection conn;

    @Override
    public List<Usuario> listar() throws SQLException {
        return null;
    }

    @Override
    public Usuario porId(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException {
        String sql;
        if(usuario.getId() != null && usuario.getId() > 0){
            sql = "UPDATE usuarios SET username = ?, email = ?, password = ? WHERE id = ? ;";
        }else{
            sql = "INSERT INTO usuarios (username, email, password) VALUES(?, ?, ?);";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getPassword());
            if(usuario.getId() != null && usuario.getId() > 0){
                stmt.setLong(4, usuario.getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    @Override
    public Usuario porUsername(String username) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, username);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    usuario = getUsuario(rs);
                }
            }
        }
        return usuario;
    }

    private static Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario usuario;
        usuario = new Usuario();
        usuario.setId(rs.getLong("id"));
        usuario.setUsername(rs.getString("username"));
        usuario.setEmail(rs.getString("email"));
        usuario.setPassword(rs.getString("password"));
        return usuario;
    }
}
