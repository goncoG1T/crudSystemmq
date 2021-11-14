<%-- 
    Document   : validaBuscaUsuario
    Created on : 09/04/2021, 10:17:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Sys_admin" %>
<%@page import="systemmq.controller.ControllerSys_admin" %>

<%
    int ID = Integer.parseInt(request.getParameter("ID"));
    Sys_admin pEntrada = new Sys_admin(ID);
    ControllerSys_admin contPes = new ControllerSys_admin();
    Sys_admin sSaida = contPes.buscar(pEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>BUSCA</h1> <br>
        <% if (sSaida != null) { %> 
            ID = <%=sSaida.getId()%> <br>
            NOME = <%=sSaida.getNome()%> <br>
            IDADE = <%=sSaida.getIdade()%> <br>
        <% } else { %> 
            Sys_admin = Não encontrado
        <% } %> 
    </div>
    </body>
</html>
