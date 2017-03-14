<%-- 
    Document   : autor
    Created on : 13-mar-2017, 16:35:54
    Author     : camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello home!</h1>
        <form method="post" action="autor.htm">
            <input type="text" id="idAutor" name="idAutor" />
            <input type="text" id="nombreAutor" name="nombreAutor" />
            <input type="text" id="tipoAutor" name="tipoAutor" />
            <input type="submit" value="enviar"/>
        </form>
        <c:forEach items="${datos}" var="dato">
            <c:out value="${dato.id}"/>
        </c:forEach>
        <c:out value="${id}"/>
    </body>
</html>
