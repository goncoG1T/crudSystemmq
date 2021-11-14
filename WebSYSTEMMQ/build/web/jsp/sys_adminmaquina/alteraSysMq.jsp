<%-- 
    Document   : alteraUsuario.jsp
    Created on : 08/04/2021, 20:13:33
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="systemmq.model.bean.Maquina" %>
<%@page import="systemmq.model.bean.Sys_admin" %>
<%@page import="systemmq.model.bean.Sys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerSys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerMaquina" %>
<%@page import="systemmq.controller.ControllerSys_admin" %>

<%
    int ID = Integer.parseInt(request.getParameter("ID"));
    Sys_adminMaquina ppEntrada = new Sys_adminMaquina(ID);
    ControllerSys_adminMaquina contSysmq = new ControllerSys_adminMaquina();
    Sys_adminMaquina smSaida = contSysmq.buscar(ppEntrada);
    
    Sys_admin sys = new Sys_admin("");
    Maquina maq = new Maquina("");
    ControllerSys_admin contSys= new ControllerSys_admin();
    ControllerMaquina contMaq = new ControllerMaquina();
    List<Sys_admin> listaSaidaSys = contSys.listar(sys);
    List<Maquina> listaSaidaMaquina = contMaq.listar(maq);
%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>ALTERA</h1>
        <form name="validaAlteraSysMq" action="validaAlteraSysMq.jsp" method="post">
            SYS_ADMIN
            <select name="SELECTSYS_ADMIN" class="browser-default">
                <% for (Sys_admin listaSys :listaSaidaSys){ %>
                    <%if(smSaida.getIdSys() == listaSys.getId() ) { %>
                        <option selected value="<%=listaSys.getId()%>"><%=listaSys.getNome()%></option>
                    <% } else { %>
                        <option value="<%=listaSys.getId()%>"><%=listaSys.getNome()%></option>
                    <% } %>
                <% } %>
            </select>
            Maquina
            <select name="SELECTMAQUINA" class="browser-default">
                <% for (Maquina listaMaquina:listaSaidaMaquina){ %>
                    <%if(smSaida.getIdMaq() == listaMaquina.getId() ) { %>
                        <option selected value="<%=listaMaquina.getId()%>"><%=listaMaquina.getModelo()%></option>
                    <% } else { %>
                        <option value="<%=listaMaquina.getId()%>"><%=listaMaquina.getModelo()%></option>
                    <% } %>
                <% } %>
            </select>
            OBS <input type="text" name="OBS" value=""> <br>
            <input type="hidden" name="ID" value="<%=smSaida.getId()%>"> <br>
            <input type="submit" name="ALTERAR" value="ALTERAR"> <br>
        </form>
    </div>
    </body>
</html>