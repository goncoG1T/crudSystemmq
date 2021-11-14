<%-- 
    Document   : validaAlteraUsuario.jsp
    Created on : 08/04/2021, 20:26:56
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Maquina" %>
<%@page import="systemmq.controller.ControllerMaquina" %>

<%
    int id = Integer.parseInt(request.getParameter("ID"));
    String modelo = request.getParameter("NOME");
    String ano = request.getParameter("IDADE");
    String os = request.getParameter("TIPO");
    Maquina maqEnt = new Maquina(id,modelo,os,ano);
    ControllerMaquina maqCont = new ControllerMaquina();
    Maquina maqSaida = maqCont.alterar(maqEnt);

%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>ALTERAÇÃO CONCLUIDA</h1>
        ID = <%=maqSaida.getId()%> <br>
        LOGIN = <%=maqSaida.getModelo()%> <br>
        SENHA = <%=maqSaida.getAno()%> <br>
        TIPO = <%=maqSaida.getOs()%> <br>
    </div>
    </body>
</html>
