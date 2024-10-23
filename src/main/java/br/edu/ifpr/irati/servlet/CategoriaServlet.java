package br.edu.ifpr.irati.servlet;

import br.edu.ifpr.irati.model.Categoria;
import br.edu.ifpr.irati.service.CategoriaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String titulo = req.getParameter("titulo");
            String descricao = req.getParameter("descricao");
            String emails = req.getParameter("emails");
            int prazoMinimo = Integer.parseInt(req.getParameter("prazominimo"));
            int prazoMaximo = Integer.parseInt(req.getParameter("prazomaximo"));
            String nomeResponsavel = req.getParameter("nomeresponsavel");
            Categoria categoria = new Categoria(0, titulo, descricao, emails, prazoMinimo, prazoMaximo, nomeResponsavel);
            CategoriaService categoriaService = new CategoriaService();
            categoriaService.salvar(categoria);
            resp.sendRedirect("index.html");
        }catch (Exception e){
            PrintWriter pw = resp.getWriter();
            pw.write("Erro!");
        }

    }
}
