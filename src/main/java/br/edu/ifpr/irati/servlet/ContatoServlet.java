package br.edu.ifpr.irati.servlet;

import br.edu.ifpr.irati.exception.ContatoException;
import br.edu.ifpr.irati.model.Categoria;
import br.edu.ifpr.irati.model.Contato;
import br.edu.ifpr.irati.service.CategoriaService;
import br.edu.ifpr.irati.service.ContatoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ContatoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        int fkidcategoria = Integer.parseInt(req.getParameter("assunto"));
        Categoria categoria = new Categoria();
        categoria.setId(fkidcategoria);//atribui uma categoria apenas para o novo cadastro
        String texto = req.getParameter("texto");
        Contato c = new Contato(0,nome,email,categoria,texto);
        ContatoService contatoService = new ContatoService();
        try {
            contatoService.salvar(c);
            resp.sendRedirect("index.html");
        } catch (ContatoException e) {
            PrintWriter pw = resp.getWriter();
            pw.print(e.getMessage());
        }

    }
}
