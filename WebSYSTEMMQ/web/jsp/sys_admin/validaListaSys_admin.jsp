<%-- 
    Document   : validaBuscaUsuario
    Created on : 09/04/2021, 10:17:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="systemmq.model.bean.Sys_admin" %>
<%@page import="systemmq.controller.ControllerSys_admin" %>

<%
    String login = request.getParameter("NOME");
    Sys_admin sEntrada = new Sys_admin(login);
    ControllerSys_admin contPes = new ControllerSys_admin();
    List<Sys_admin> sysSaida = contPes.listar(sEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    
    <div class="container"/>
        <h1>LISTA</h1> <br>
        <% if(!(sysSaida.isEmpty())) { %>
            <% for (Sys_admin listaSys :sysSaida){ %>
                ID = <%=listaSys.getId()%> |
                NOME = <%=listaSys.getNome()%> |
                IDADE = <%=listaSys.getIdade()%> - <a href="sys_admin/alteraSys_admin.jsp?ID=<%=listaSys.getId()%>">Altera</a> - <a href="sys_admin/validaExcluiSys_admin.jsp?ID=<%=listaSys.getId()%>">Excluir</a> <br>
            <% } %>
        <% } else { %>
            LISTA VAZIA
       <% } %>

    </div>
    
</html>
