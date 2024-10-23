package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.ContatoDAO;
import br.edu.ifpr.irati.exception.ContatoException;
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

    public void salvar(Contato c) throws ContatoException {

        //aplicar regras
        //e-mail válido
        //tem que informar um nome
        ContatoDAO contatoDAO = new ContatoDAO();
        contatoDAO.salvar(c);

        //nesta classe é implementada a regra do negócio
        /*
        Um exemplo possível seria encaminhar o contato
        para setores diferentes via e-mail a depender do
        assunto
         */


    }

}
