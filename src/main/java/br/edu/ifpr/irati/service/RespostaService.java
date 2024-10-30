package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.ContatoDAO;
import br.edu.ifpr.irati.dao.RespostaDAO;
import br.edu.ifpr.irati.exception.ContatoException;
import br.edu.ifpr.irati.exception.RespostaException;
import br.edu.ifpr.irati.model.Contato;
import br.edu.ifpr.irati.model.Resposta;

public class RespostaService {
    private RespostaDAO respostaDAO;

    public RespostaService() { respostaDAO = new RespostaDAO(); }

    public RespostaService(RespostaDAO respostaDAO) { this.respostaDAO = respostaDAO; }

    public void salvar(Resposta r) throws RespostaException {

        //aplicar regras
        //e-mail válido
        //tem que informar um nome
        RespostaDAO respostaDAO = new RespostaDAO();
        respostaDAO.salvar(r);

        //nesta classe é implementada a regra do negócio
        /*
        Um exemplo possível seria encaminhar o contato
        para setores diferentes via e-mail a depender do
        assunto
         */


    }
}
