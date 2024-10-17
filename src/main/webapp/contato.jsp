<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifpr.irati.service.CategoriaService"%>
<%@page import="br.edu.ifpr.irati.service.ContatoService"%>
<%@page import="br.edu.ifpr.irati.model.Categoria"%>
<%@page import="br.edu.ifpr.irati.model.Contato"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.Integer"%>

<%
CategoriaService categoriaService = new CategoriaService();
ContatoService contatoService = new ContatoService();
List<Categoria> categorias = categoriaService.buscarTodos();
int id = 0;
Contato contato = new Contato();
try{
    id = Integer.parseInt(request.getParameter("id"));
    contato = contatoService.buscarPorId(id);
}catch(Exception e){
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Fale Conosco</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
    <div class="row">
        <div class="col s12">
            <div class="col s6 offset-s3">
                <h3>Fale conosco</h3>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col s12">
            <!--<div class="col s3"></div>-->
            <div class="col s6 offset-s3">
                <form class="col s12" action="contato" method="post">
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">person</i>
                            <input id="nome" name="nome" type="text" class="validate" value="<%=contato.getNome()%>">
                            <label for="nome">Nome</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">email</i>
                            <input id="email" name="email" type="email" class="validate" value="<%=contato.getEmail()%>">
                            <label for="email">Email</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">subject</i>
                            <select id="assunto" name="assunto">
                                <option value="" disabled selected>Escolha a categoria</option>
                                <%
                                for (Categoria c: categorias){
                                    String selecionado = "";
                                    if (contato.getAssunto().getId() == c.getId()){
                                        selecionado = "selected";
                                    }
                                %>
                                    <option value=<%=c.getId()%> <%=selecionado%>> <%=c.getTitulo()%> </option>
                                <%
                                }
                                %>
                            </select>
                            <label>Materialize Select</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">mode_edit</i>
                            <textarea id="texto" name="texto" class="materialize-textarea"><%=contato.getTexto()%></textarea>
                            <label for="texto">Texto</label>
                        </div>
                    </div>
                    <div class="row">
                        <button class="btn waves-effect waves-light col s12" type="submit" name="enviar">Enviar Mensagem
                        </button>
                    </div>
                </form>
            </div>
            <!--<div class="col s3"></div>-->
        </div>
    </div>

    <script type="text/javascript" src="//code.jquery.com/jquery-2.1.4.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script>
        $(document).ready(function(){
            $('select').formSelect();
        });
    </script>
</body>
</html>