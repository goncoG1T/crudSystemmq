<%-- 
    Document   : validaBuscaUsuario
    Created on : 09/04/2021, 10:17:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="systemmq.model.bean.Maquina" %>
<%@page import="systemmq.controller.ControllerMaquina" %>

<%
    String login = request.getParameter("NOME");
    Maquina mEntrada = new Maquina(login);
    ControllerMaquina ContMaq = new ControllerMaquina();
    List<Maquina> psSaida = ContMaq.listar(mEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>LISTA</h1> <br>
        <% if(!(psSaida.isEmpty())) { %>
            <% for (Maquina listaMaquina:psSaida){ %>
            Maquina= ID = <%=listaMaquina.getId()%> | NOME = <%=listaMaquina.getModelo()%> | IDADE = <%=listaMaquina.getAno()%> | Tipo = <%=listaMaquina.getOs()%> - <a href="maquina/alteraMaquina.jsp?ID=<%=listaMaquina.getId()%>">Altera</a> - <a href="maquina/validaExcluiMaquina.jsp?ID=<%=listaMaquina.getId()%>">Excluir</a> <br>
            <% } %>
       <% } else { %>
            LISTA VAZIA
       <% } %>

    </div>
    </body>
</html>
