<%-- 
    Document   : validaInseriUsuario
    Created on : 08/04/2021, 20:39:51
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Sys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerSys_adminMaquina" %>

<%
    int idPes = Integer.parseInt(request.getParameter("SELECTPESSOA"));
    int idMaquina= Integer.parseInt(request.getParameter("SELECTPET"));
    String obs = request.getParameter("OBS");
    
    Sys_adminMaquina pespetEnt = new Sys_adminMaquina(0,idPes,idPet,obs);
    ControllerSys_adminMaquina pespetCont = new ControllerSys_adminMaquina();
    Sys_adminMaquina pespetSaida = pespetCont.inserir(pespetEnt);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>INCLUSÃO CONCLUIDA</h1>
        ID = <%=pespetSaida.getId()%> <br>
        IDPES = <%=pespetSaida.getIdPes()%> <br>
        IDMaquina= <%=pespetSaida.getIdPet()%> <br>
        TIPO = <%=pespetSaida.getObs()%> <br>
    </div>
    </body>
</html>
