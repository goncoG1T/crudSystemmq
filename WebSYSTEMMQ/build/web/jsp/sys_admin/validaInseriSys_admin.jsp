<%-- 
    Document   : validaInseriUsuario
    Created on : 08/04/2021, 20:39:51
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Sys_admin" %>
<%@page import="systemmq.controller.ControllerSys_admin" %>

<%
    String nome = request.getParameter("NOME");
    String idade = request.getParameter("IDADE");
    Sys_admin sysEntrada = new Sys_admin(0, nome, idade);
    ControllerSys_admin pesCont = new ControllerSys_admin();
    Sys_admin sSaida = pesCont.inserir(sysEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>INCLUSÃO CONCLUIDA</h1>
            ID = <%=sSaida.getId()%> <br>
            NOME = <%=sSaida.getNome()%> <br>
            IDADE = <%=sSaida.getIdade()%> <br>
    </div>
    </body>
</html>
