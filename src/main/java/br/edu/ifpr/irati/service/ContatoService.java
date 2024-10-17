package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.ContatoDAO;
import br.edu.ifpr.irati.model.Contato;

public class ContatoService {

    private ContatoDAO contatoDAO;

    public ContatoService(){
        contatoDAO = new ContatoDAO();
    }

    public ContatoService(ContatoDAO contatoDAO) {
        this.contatoDAO = contatoDAO;
    }

    public Contato buscarPorId(int id){
        return contatoDAO.buscarPorId(id);
    }

}
