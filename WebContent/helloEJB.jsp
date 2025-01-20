<%@ include file="header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Приветствие через EJB</title>
</head>
<body>
    <h1>Приветствие через EJB</h1>
    <form action="helloEJB.jsp" method="get">
        <label for="name">Введите ваше имя:</label><br>
        <input type="text" id="name" name="name" required><br><br>
        <input type="submit" value="Поздороваться">
    </form>
    <br>
    <c:if test="${not empty param.name}">
        <p>Привет, ${param.name}!</p>
    </c:if>
</body>
</html>
<%@ include file="footer.jspf" %>
