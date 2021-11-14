<%-- 
    Document   : inseriUsuario
    Created on : 08/04/2021, 20:37:49
    Author     : User
--%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/formatacao.inc" %>
    <title>JSP Page</title>
    <body>
    <div class="container"/>
        <h1>INSERI</h1>
        <form name="validaInserirMaquina" action="validaInserirMaquina.jsp" method="post">
            MODELO <input type="text" name="MODELO" value=""> <br>
            ANO <input type="text" name="ANO" value=""> <br>
            OS <input type="text" name="OS" value=""> <br>
            <input type="submit" name="INSERIR" value="INSERIR"> <br>
        </form>
    </div>
   </body>
</html>