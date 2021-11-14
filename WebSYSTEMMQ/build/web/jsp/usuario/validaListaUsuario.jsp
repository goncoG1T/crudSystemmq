<%-- 
    Document   : validaBuscaUsuario
    Created on : 09/04/2021, 10:17:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="systemmq.model.bean.Usuario" %>
<%@page import="systemmq.controller.ControllerUsuario" %>

<%
    String login = request.getParameter("LOGIN");
    Usuario uEntrada = new Usuario(login);
    ControllerUsuario contUsu = new ControllerUsuario();
    List<Usuario> usSaida = contUsu.listar(uEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>LISTA</h1> <br>
        <% if(!(usSaida.isEmpty())) { %>
            <% for (Usuario listaUsu :usSaida){ %>
                USUARIO = ID = <%=listaUsu.getId()%> | LOGIN = <%=listaUsu.getLogin()%> | SENHA = <%=listaUsu.getSenha()%> | STATUS = <%=listaUsu.getStatus()%> | TIPO = <%=listaUsu.getTipo()%> - <a href="../usuario/alteraUsuario.jsp?ID=<%=listaUsu.getId()%>">Altera</a> - <a href="../usuario/validaExcluiUsuario.jsp?ID=<%=listaUsu.getId()%>">Excluir</a> <br>
            <% } %>
       <% } else { %>
            LISTA VAZIA
       <% } %>

    </div>
    </body>
</html>
