package br.edu.ifpr.irati.servlet;

import br.edu.ifpr.irati.model.Categoria;
import br.edu.ifpr.irati.service.CategoriaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ContatoPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<!DOCTYPE html>");
        pw.write("<html>");
        pw.write("<head>");
        pw.write("<meta charset='utf-8'>");
        pw.write("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        pw.write("<title>Fale Conosco</title>");
        pw.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        pw.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">");
        pw.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">");

        pw.write("</head>");
        pw.write("<body>");
        pw.write("<div class=\"row\">");
        pw.write("<div class=\"col s12\">");
        pw.write("<div class=\"col s6 offset-s3\">");
        pw.write("<h3>Fale conosco</h3>");
        pw.write("</div>");
        pw.write("</div>");
        pw.write("<div class=\"row\">");
        pw.write("<div class=\"col s12\">");
        pw.write("<div class=\"col s6 offset-s3\">");
        pw.write("<form class=\"col s12\" action=\"contato\" method=\"post\">");
        pw.write("<div class=\"row\">");
        pw.write("<div class=\"input-field col s12\">");
        pw.write("<i class=\"material-icons prefix\">person</i>");
        pw.write("<input id=\"nome\" name=\"nome\" type=\"text\" class=\"validate\">");
        pw.write("<label for=\"nome\">Nome</label>");
        pw.write("</div>");
        pw.write("</div>");
        pw.write("<div class=\"row\">");
        pw.write("<div class=\"input-field col s12\">");
        pw.write("<i class=\"material-icons prefix\">email</i>");
        pw.write("<input id=\"email\" name=\"email\" type=\"email\" class=\"validate\">");
        pw.write("<label for=\"email\">Email</label>");
        pw.write("</div>");
        pw.write("</div>");
        pw.write("<div class=\"row\">");


        pw.write("<div class=\"input-field col s12\">");
        pw.write("<i class=\"material-icons prefix\">subject</i>");
        pw.write("<select id=\"assunto\" name=\"assunto\">");
        pw.write("<option value=\"\" disabled selected>Escolha o assunto</option>");
        /*
        Acionar o Service de categoria para obter uma lista
        com todas as categorias.
         */
        CategoriaService categoriaService = new CategoriaService();
        List<Categoria> categorias = categoriaService.buscarTodos();
        for (Categoria c: categorias){
            pw.write("<option value="+c.getId()+">"+c.getTitulo()+"</option>");
        }
        pw.write("</select>");
        pw.write("<label>Assunto</label>");
        pw.write("</div>");
        pw.write("</div>");
        pw.write("<div class=\"row\">");
        pw.write("<div class=\"input-field col s12\">");
        pw.write("<i class=\"material-icons prefix\">mode_edit</i>");
        pw.write("<textarea id=\"texto\" name=\"texto\" class=\"materialize-textarea\"></textarea>");
        pw.write("<label for=\"texto\">Texto</label>");
        pw.write("</div>");
        pw.write("</div>");
        pw.write("<div class=\"row\">");
        pw.write("<button class=\"btn waves-effect waves-light col s12\" type=\"submit\" name=\"enviar\">Enviar Mensagem");
        pw.write("</button>");
        pw.write("</div>");
        pw.write("</form>");
        pw.write("</div>");
        pw.write("</div>");
        pw.write("</div>");
        pw.write("<script type=\"text/javascript\" src=\"//code.jquery.com/jquery-2.1.4.js\"></script>");
        pw.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>");
        pw.write("<script>");
        pw.write("$(document).ready(function(){");
        pw.write("$('select').formSelect();");
        pw.write("});");
        pw.write("</script>");
        pw.write("</body>");
        pw.write("</html>");

    }
}
