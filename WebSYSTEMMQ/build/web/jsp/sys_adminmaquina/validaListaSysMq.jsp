<%-- 
    Document   : validaBuscaUsuario
    Created on : 09/04/2021, 10:17:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="systemmq.model.bean.Sys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerSys_adminMaquina" %>

<%
    String obs = request.getParameter("OBS");
    Sys_adminMaquina pEntrada = new Sys_adminMaquina(obs);
    ControllerSys_adminMaquina ContMaq = new ControllerSys_adminMaquina();
    List<Sys_adminMaquina> psSaida = ContMaq.listar(pEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>LISTA</h1> <br>
        <% if(!(psSaida.isEmpty())) { %>
            <% for (Sys_adminMaquina listaPet :psSaida){ %>
            PES-Maquina= ID = <%=listaPet.getId()%> | NOMEPES = <%=listaPet.getPes().getNome()%> | NOMEMaquina= <%=listaPet.getPet().getNome()%> | IDPED = <%=listaPet.getIdPes()%> | IDMaquina= <%=listaPet.getIdPet()%> | OBS = <%=listaPet.getObs()%>- <a href="sys_adminmaquina/alteraPesPet.jsp?ID=<%=listaPet.getId()%>">Altera</a> - <a href="sys_adminmaquina/validaExcluiPesPet.jsp?ID=<%=listaPet.getId()%>">Excluir</a> <br>
            <% } %>
       <% } else { %>
            LISTA VAZIA
       <% } %>

    </div>
    </body>
</html>
