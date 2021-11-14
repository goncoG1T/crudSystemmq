<%-- 
    Document   : validaInseriUsuario
    Created on : 08/04/2021, 20:39:51
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Maquina" %>
<%@page import="systemmq.controller.ControllerMaquina" %>

<%
    String modelo = request.getParameter("MODELO");
    String ano = request.getParameter("ANO");
    String os = request.getParameter("OS");
    Maquina maqEnt = new Maquina (0,modelo, ano, os);
    ControllerMaquina maqCont = new ControllerMaquina();
    Maquina maqSaida = maqCont.inserir(maqEnt);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>INCLUSÃO CONCLUIDA</h1>
        ID = <%=maqSaida.getId()%> <br>
        MODELO = <%=maqSaida.getModelo()%> <br>
        ANO = <%=maqSaida.getAno()%> <br>
        OS = <%=maqSaida.getOs()%> <br>
    </div>
    </body>
</html>
