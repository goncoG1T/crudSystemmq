<%-- 
    Document   : validaExcluiUsuario
    Created on : 08/04/2021, 20:34:03
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Maquina" %>
<%@page import="systemmq.controller.ControllerMaquina" %>

<%
    int ID = Integer.parseInt(request.getParameter("ID"));
    Maquina mEntrada = new Maquina(ID);
    ControllerMaquina ContMaq = new ControllerMaquina();
    Maquina mSaida = ContMaq.excluir(mEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>VALIDA EXCLUSÃO</h1>
        ID = <%=mSaida.getId()%> <br>
        MODELO = <%=mSaida.getModelo()%> <br>
        ANO = <%=mSaida.getAno()%> <br>
        OS = <%=mSaida.getOs()%> <br>
    </div>
    </body>
</html>
