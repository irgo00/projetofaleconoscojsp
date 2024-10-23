<%@ page import="br.edu.ifpr.irati.model.Contato" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifpr.irati.service.ContatoService" %>

<%
    ContatoService contatoService = new ContatoService();
    List<Contato> contatos = contatoService.buscarTodos();
%>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LISTA DE CONTATOS</title>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body>

<div>
    <h4 class="center-align">Tabela de Contatos</h4>
</div>
<br>
<table class="striped centered">
    <thead>
    <tr>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Assunto</th>
        <th>Texto</th>
    </tr>
    </thead>

    <tbody>
    <!--tr = linha, td = coluna-->

    <%
    for(Contato c: contatos){
    %>
        <tr>
            <td><%out.print(c.getNome());%></td>
            <td><%out.print(c.getEmail());%></td>
            <td><%out.print(c.getAssunto().getTitulo());%></td>
            <td><%out.print(c.getTexto());%></td>
            <td>
                <button class="btn waves-effect waves-light" type="submit" name="action">Responder
                    <i class="material-icons right">send</i>
                </button>
            </td>
            <td>
                <button class="btn waves-effect waves-light red accent-4" type="submit" name="action">Encerrar
                    <i class="large material-icons right">delete</i>
                </button>
            </td>
        </tr>
    <%
    }
    %>

    </tbody>
</table>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>