<%-- 
    Document   : validaExcluiUsuario
    Created on : 08/04/2021, 20:34:03
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Sys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerSys_adminMaquina" %>

<%
    int ID = Integer.parseInt(request.getParameter("ID"));
    Sys_adminMaquina pEntrada = new Sys_adminMaquina(ID);
    ControllerSys_adminMaquina ContMaq = new ControllerSys_adminMaquina();
    Sys_adminMaquina sSaida = ContMaq.excluir(pEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>VALIDA EXCLUSÃO</h1>
        ID = <%=sSaida.getId()%> <br>
        IDPES = <%=sSaida.getIdPes()%> <br>
        IDPET = <%=sSaida.getIdPet()%> <br>
        OBS = <%=sSaida.getObs()%> <br>
    </div>
    </body>
</html>
