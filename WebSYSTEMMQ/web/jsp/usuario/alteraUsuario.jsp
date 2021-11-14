<%-- 
    Document   : alteraUsuario.jsp
    Created on : 08/04/2021, 20:13:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Usuario" %>
<%@page import="systemmq.controller.ControllerUsuario" %>

<%
    int id = Integer.parseInt(request.getParameter("ID"));
    Usuario uEntrada = new Usuario(id);
    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario uSaida = usuCont.buscar(uEntrada);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>ALTERA</h1>
        <form name="validaAlteraUsuario" action="validaAlteraUsuario.jsp" method="post">
            ID <%=uSaida.getId()%> <br>
            LOGIN <input type="text" name="LOGIN" value="<%=uSaida.getLogin()%>"> <br>
            SENHA <input type="text" name="SENHA" value="<%=uSaida.getSenha()%>"> <br>
            STATUS <input type="text" name="STATUS" value="<%=uSaida.getStatus()%>"> <br>
            TIPO <input type="text" name="TIPO" value="<%=uSaida.getTipo()%>"> <br>
            <input type="hidden" name="ID" value="<%=uSaida.getId()%>"> <br>
            <input type="submit" name="ALTERAR" value="ALTERAR"> <br>
        </form>
    </div>
    </body>
</html>