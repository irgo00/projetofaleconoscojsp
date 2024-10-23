package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.exception.ContatoException;
import br.edu.ifpr.irati.model.Categoria;
import br.edu.ifpr.irati.model.Contato;
import br.edu.ifpr.irati.service.CategoriaService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public List<Contato> buscarTodos(){
        CategoriaService cs = new CategoriaService();
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        List<Contato> contatos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT id, nome, email, fkIdCategoria, texto " +
                    "FROM contato");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                Categoria assunto = cs.buscarPorId(rs.getInt(4));
                String texto = rs.getString(5);
                contatos.add(new Contato(id, nome, email, assunto, texto));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contatos;
    }

    public void salvar(Contato c) throws ContatoException {

        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            String sql = "insert into contato " +
                    "(nome, email, fkidcategoria, texto) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEmail());
            ps.setInt(3, c.getAssunto().getId());
            ps.setString(4, c.getTexto());
            ps.execute();
            ps.close();
            con.close();
        }catch (SQLException sqle){
            throw new ContatoException(sqle.getMessage());
        }
    }


    public Contato buscarPorId(int id){
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        Contato contato = new Contato();
        String sql = "select con.nome, con.email, " +
                     "con.texto, cat.id, cat.titulo, " +
                     "cat.descricao, cat.emails, " +
                     "cat.prazominimo, cat.prazomaximo, " +
                     "cat.nomeresponsavel " +
                     "from contato con " +
                     "inner join categorias cat " +
                     "on con.fkidcategoria = cat.id " +
                     "where con.id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String nome = rs.getString(1);
                String email = rs.getString(2);
                String texto = rs.getString(3);

                int idCat = rs.getInt(4);
                String tituloCat = rs.getString(5);
                String descricaoCat = rs.getString(6);
                String emailsCat = rs.getString(7);
                int prazoMinimoCat = rs.getInt(8);
                int prazoMaximoCat = rs.getInt(9);
                String nomeResponsavelCat = rs.getString(10);
                Categoria categoria = new Categoria(idCat,tituloCat,descricaoCat,emailsCat,prazoMinimoCat,prazoMaximoCat,nomeResponsavelCat);
                contato = new Contato(id, nome, email, categoria, texto);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contato;
    }

}
