<%@ include file="header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить новую книгу</title>
</head>
<body>
    <h1>Добавить новую книгу</h1>
    <form action="BookController?action=insert" method="post">
        <label for="title">Название:</label><br>
        <input type="text" id="title" name="title" required><br><br>

        <label for="author">Автор:</label><br>
        <select id="author" name="author" required>
            <c:forEach var="author" items="${listAuthors}">
                <option value="${author.id}">${author.firstName} ${author.lastName}</option>
            </c:forEach>
        </select><br><br>

        <label for="category">Категория:</label><br>
        <select id="category" name="category" required>
            <c:forEach var="category" items="${listCategories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select><br><br>

        <label for="year">Год издания:</label><br>
        <input type="number" id="year" name="year" min="1900" max="2100" required><br><br>

        <label for="isbn">ISBN:</label><br>
        <input type="text" id="isbn" name="isbn" required><br><br>

        <input type="submit" value="Добавить">
    </form>
</body>
</html>
<%@ include file="footer.jspf" %>
