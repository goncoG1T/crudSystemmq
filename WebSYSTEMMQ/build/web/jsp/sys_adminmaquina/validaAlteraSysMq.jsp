<%-- 
    Document   : validaAlteraUsuario.jsp
    Created on : 08/04/2021, 20:26:56
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Sys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerSys_adminMaquina" %>

<%
    int id = Integer.parseInt(request.getParameter("ID"));
    int idPes = Integer.parseInt(request.getParameter("SELECTPESSOA"));
    int idMaquina= Integer.parseInt(request.getParameter("SELECTPET"));
    String obs = request.getParameter("OBS");
    
    Sys_adminMaquina pespetEnt = new Sys_adminMaquina(id,idPes,idPet,obs);
    ControllerSys_adminMaquina pespetCont = new ControllerSys_adminMaquina();
    Sys_adminMaquina pespetSaida = pespetCont.alterar(pespetEnt);
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
