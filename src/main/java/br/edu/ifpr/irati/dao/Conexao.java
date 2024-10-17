package br.edu.ifpr.irati.dao;

import java.sql.*;

public class Conexao {
    
    public Connection conectar() {
        
        try {
            //Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Parâmetros de conexão
            //url qualquer como exemplo
            //https://www.reitoria.ifpr.edu.br:80/editais?id=2
            String url = "jdbc:mysql://localhost:3306/contatos?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8";
            //usuário
            String usuario = "root";
            //senha
            String senha = "root";
            
            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Não encontrei o Driver.");
            System.exit(1);
        } catch (SQLException ex) {
            System.out.println("Não conectou com o banco de dados. Verifique os parâmetros de conexão.");
            System.out.println(ex);
            System.exit(2);
        }
        return null;
    }
    
}
