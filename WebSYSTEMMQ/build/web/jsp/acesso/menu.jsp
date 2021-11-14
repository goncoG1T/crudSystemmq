<%-- 
    Document   : menu
    Created on : 09/04/2021, 10:01:00
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="systemmq.model.bean.Usuario" %>
<%@page import="systemmq.controller.ControllerUsuario" %>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario uEntrada = new Usuario(login,senha);
    ControllerUsuario contUsu = new ControllerUsuario();
    Usuario uSaida = contUsu.valida(uEntrada);
%>

<html>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
    <h1>MENU</h1> <br>
    <% if(uSaida != null) { %> 
        Usuario = <%=uSaida.getId()%> | <%=uSaida.getLogin()%> | <%=uSaida.getSenha()%> | <%=uSaida.getStatus()%> | <%=uSaida.getTipo()%> <br>
        <h1>Usuario</h1> 
        <a href="../usuario/buscaUsuario.jsp">Busca</a> 
        | <a href="../usuario/listaUsuario.jsp">Lista</a> 
        | <a href="../usuario/inserirUsuario.jsp">Inserir</a>
        <h1>Sys_admin</h1> 
        <a href="../sys_admin/buscaSys_admin.jsp">Busca</a> 
        | <a href="../sys_admin/listaSys_admin.jsp">Lista</a> 
        | <a href="../sys_admin/inserirSys_admin.jsp">Inserir</a>
        <h1>Maquina</h1> 
        <a href="../maquina/buscaMaquina.jsp">Busca</a> 
        | <a href="../maquina/listaMaquina.jsp">Lista</a> 
        | <a href="../maquina/inserirMaquina.jsp">Inserir</a>
        <h1>Sys_admin-Maquina</h1> 
        <a href="../sys_adminmaquina/buscaSysmq.jsp">Busca</a> 
        | <a href="../sys_adminmaquina/listaSysmq.jsp">Lista</a> 
        | <a href="../sys_adminmaquina/inserirSysmq.jsp">Inserir</a>
    <% } else { %> 
        <h1>Usuário Invalido</h1> 
    <% } %> 
    </div>
   </body>
</html>