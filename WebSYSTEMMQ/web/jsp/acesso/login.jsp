<%-- 
    Document   : login
    Created on : 09/04/2021, 10:00:51
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
    <h1>LOGIN</h1>
        <FORM name="LOGIN" action="menu.jsp" method="post">
            LOGIN <input type="text" name ="LOGIN" value=""> <br>
            SENHA <input type="password" name ="SENHA" value=""> <br>
            <input type="submit" name ="ENTRAR" value="ENTRAR">
        </FORM>
    </body>
</div>
</html>
