package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.model.Categoria;
import br.edu.ifpr.irati.model.Contato;

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

    public Categoria buscarPorId(int id){
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        Categoria categoria = null;
        String sql = "SELECT id, titulo, descricao, emails, prazominimo, prazomaximo, nomeresponsavel " +
                "FROM categorias WHERE id = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idCat = rs.getInt(1);
                String tituloCat = rs.getString(2);
                String descricaoCat = rs.getString(3);
                String emailsCat = rs.getString(4);
                int prazoMinimoCat = rs.getInt(5);
                int prazoMaximoCat = rs.getInt(6);
                String nomeResponsavelCat = rs.getString(7);
                categoria = new Categoria(idCat,tituloCat,descricaoCat,emailsCat,prazoMinimoCat,prazoMaximoCat,nomeResponsavelCat);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }
}
