<%-- 
    Document   : validaAlteraUsuario.jsp
    Created on : 08/04/2021, 20:26:56
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Sys_admin" %>
<%@page import="systemmq.controller.ControllerSys_admin" %>

<%
    int id = Integer.parseInt(request.getParameter("ID"));
    String nome = request.getParameter("NOME");
    String idade = request.getParameter("IDADE");
    
    Sys_admin sysEntrada = new Sys_admin(id, nome, idade);
    ControllerSys_admin sysCont = new ControllerSys_admin();
    Sys_admin sSaida = sysCont.alterar(sysEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>ALTERAÇÃO CONCLUIDA</h1>
            ID = <%=sSaida.getId()%> <br>
            NOME = <%=sSaida.getNome()%> <br>
            IDADE = <%=sSaida.getIdade()%> <br>
    </div>
    </body>
</html>
