package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void salvar(Categoria categoria){
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try {
            PreparedStatement ps = con.prepareStatement("insert into categorias " +
                    "(titulo, descricao, emails, prazominimo, prazomaximo, nomeresponsavel) values (?,?,?,?,?,?)");
            ps.setString(1, categoria.getTitulo());
            ps.setString(2, categoria.getDescricao());
            ps.setString(3, categoria.getEmails());
            ps.setInt(4, categoria.getPrazoMaximo());
            ps.setInt(5, categoria.getPrazoMaximo());
            ps.setString(6,categoria.getNomeResponsavel());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> buscarTodos(){
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        List<Categoria> categorias = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select id, " +
                    "titulo, descricao, emails, prazominimo, prazomaximo, nomeresponsavel from categorias order by titulo asc");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String descricao = rs.getString(3);
                String emails = rs.getString(4);
                int prazoMinimo = rs.getInt(5);
                int prazoMaximo = rs.getInt(6);
                String nomeResponsavel = rs.getString(7);
                categorias.add(new Categoria(id, titulo, descricao, emails, prazoMinimo, prazoMaximo, nomeResponsavel));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }

}
