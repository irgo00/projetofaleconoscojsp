package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.exception.ContatoException;
import br.edu.ifpr.irati.exception.RespostaException;
import br.edu.ifpr.irati.model.Contato;
import br.edu.ifpr.irati.model.Resposta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RespostaDAO {

    public void salvar(Resposta r) throws RespostaException {

        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            String sql = "insert into resposta " +
                    "(texto, fkIdContato) values (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, r.getTexto());
            ps.setInt(2, r.getFkIdContato());
            ps.execute();
            ps.close();
            con.close();
        }catch (SQLException sqle){
            throw new RespostaException(sqle.getMessage());
        }
    }
}
