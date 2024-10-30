package br.edu.ifpr.irati.servlet;

import br.edu.ifpr.irati.exception.ContatoException;
import br.edu.ifpr.irati.exception.RespostaException;
import br.edu.ifpr.irati.model.Categoria;
import br.edu.ifpr.irati.model.Contato;
import br.edu.ifpr.irati.model.Resposta;
import br.edu.ifpr.irati.service.ContatoService;
import br.edu.ifpr.irati.service.RespostaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RespostaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String texto = req.getParameter("resposta");
        int fkIdContato = Integer.parseInt(req.getParameter("id"));
        Resposta r = new Resposta(0, texto, fkIdContato);
        RespostaService rs = new RespostaService();
        try {
            rs.salvar(r);
            resp.sendRedirect("index.html");
        } catch (RespostaException e) {
            throw new RuntimeException(e);
        }
    }
}
