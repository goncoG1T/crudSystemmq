<%-- 
    Document   : alteraUsuario.jsp
    Created on : 08/04/2021, 20:13:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Maquina" %>
<%@page import="systemmq.controller.ControllerMaquina" %>

<%
    int ID = Integer.parseInt(request.getParameter("ID"));
    Maquina mEntrada = new Maquina(ID);
    ControllerMaquina contMaq = new ControllerMaquina();
    Maquina mSaida = contMaq.buscar(mEntrada);
%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>ALTERA</h1>
        <form name="validaAlteraPet" action="validaAlteraPet.jsp" method="post">
            ID <%=mSaida.getId()%> <br>
            NOME <input type="text" name="NOME" value="<%=mSaida.getModelo()%>"> <br>
            IDADE <input type="text" name="IDADE" value="<%=mSaida.getAno()%>"> <br>
            TIPO <input type="text" name="TIPO" value="<%=mSaida.getOs()%>"> <br>
            <input type="hidden" name="ID" value="<%=mSaida.getId()%>"> <br>
            <input type="submit" name="ALTERAR" value="ALTERAR"> <br>
        </form>
    </div>
    </body>
</html>