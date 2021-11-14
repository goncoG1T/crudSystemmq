<%-- 
    Document   : inseriUsuario
    Created on : 08/04/2021, 20:37:49
    Author     : User
--%>
<%@page import="java.util.List"%>
<%@page import="systemmq.model.bean.Maquina" %>
<%@page import="systemmq.model.bean.Sys_admin" %>
<%@page import="systemmq.model.bean.Sys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerSys_adminMaquina" %>
<%@page import="systemmq.controller.ControllerMaquina" %>
<%@page import="systemmq.controller.ControllerSys_admin" %>
<%
    Sys_admin sys = new Sys_admin("");
    Maquina Maquina = new Maquina("");
    ControllerSys_admin contSys = new ControllerSys_admin();
    ControllerMaquina contMaq = new ControllerMaquina();
    List<Sys_admin> listaSaidaSys = contSys.listar(sys);
    List<Maquina> listaSaidaMaquina= contMaq.listar(Maquina);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>INSERIR</h1>
        <form name="validaInseriSysMq" action="validaInseriSysMq.jsp" method="post">
            SYS_ADMIN 
            <select name="SELECTSYS_ADMIN" class="browser-default">
                <% for (Sys_admin listaSys :listaSaidaSys){ %>
                    <option value="<%=listaSys.getId()%>"><%=listaSys.getNome()%></option>
                <% } %>
            </select>
            Maquina
            <select name="SELECTMAQUINA" class="browser-default">
                <% for (Maquina listaMaquina:listaSaidaMaquina){ %>
                    <option value="<%=listaMaquina.getId()%>"><%=listaMaquina.getModelo()%></option>
                <% } %>
            </select>
            OBS <input type="text" name="OBS" value=""> <br>
            <input type="submit" name="INSERIR" value="INSERIR"> <br>
        </form>
    </div>
   </body>
</html>