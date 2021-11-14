<%-- 
    Document   : validaBuscaUsuario
    Created on : 09/04/2021, 10:17:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Maquina" %>
<%@page import="systemmq.controller.ControllerMaquina" %>

<%
    int ID = Integer.parseInt(request.getParameter("ID"));
    Maquina mEntrada = new Maquina(ID);
    ControllerMaquina contMaq = new ControllerMaquina();
    Maquina mSaida = contMaq.buscar(mEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>BUSCA</h1> <br>
        <% if (mSaida != null) { %> 
            Maquina= <%=mSaida.getId()%> | <%=mSaida.getModelo()%> | <%=mSaida.getAno()%> | <%=mSaida.getOs()%>
        <% } else { %> 
            Usuario = Não encontrado
        <% } %> 
    </div>
    </body>
</html>
