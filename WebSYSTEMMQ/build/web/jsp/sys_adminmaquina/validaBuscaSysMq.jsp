<%-- 
    Document   : validaBuscaUsuario
    Created on : 09/04/2021, 10:17:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Sys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerSys_adminMaquina" %>

<%
    int ID = Integer.parseInt(request.getParameter("ID"));
    Sys_adminMaquina pEntrada = new Sys_adminMaquina(ID);
    ControllerSys_adminMaquina ContMaq = new ControllerSys_adminMaquina();
    Sys_adminMaquina pSaida = ContMaq.buscar(pEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>BUSCA</h1> <br>
        <% if (pSaida != null) { %> 
        Maquina= <%=pSaida.getId()%> | <%=pSaida.getIdPes()%> | <%=pSaida.getIdPet()%> | <%=pSaida.getObs()%>
        <% } else { %> 
            PesPet = Não encontrado
        <% } %> 
    </div>
    </body>
</html>
