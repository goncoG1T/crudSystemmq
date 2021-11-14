<%-- 
    Document   : alteraUsuario.jsp
    Created on : 08/04/2021, 20:13:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Sys_admin" %>
<%@page import="systemmq.controller.ControllerSys_admin" %>

<%
    int id = Integer.parseInt(request.getParameter("ID"));
    Sys_admin sEntrada = new Sys_admin(id);
    ControllerSys_admin pesCont = new ControllerSys_admin();
    Sys_admin sSaida = pesCont.buscar(sEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>ALTERA</h1>
        <form name="validaAlteraSys_admin" action="validaAlteraSys_admin.jsp" method="post">
            ID <%=sSaida.getId()%> <br>
            NOME <input type="text" name="NOME" value="<%=sSaida.getNome()%>"> <br>
            IDADE <input type="text" name="IDADE" value="<%=sSaida.getIdade()%>"> <br>
            <input type="hidden" name="ID" value="<%=sSaida.getId()%>"> <br>
            <input type="submit" name="ALTERAR" value="ALTERAR"> <br>
        </form>
    </div>
    </body>
</html>