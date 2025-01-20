<%@ include file="header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редактировать книгу</title>
</head>
<body>
    <h1>Редактировать книгу</h1>
    <form action="BookController?action=update" method="post">
        <input type="hidden" name="id" value="${book.id}">

        <label for="title">Название:</label><br>
        <input type="text" id="title" name="title" value="${book.title}" required><br><br>

        <label for="author">Автор:</label><br>
        <select id="author" name="author" required>
            <c:forEach var="author" items="${listAuthors}">
                <option value="${author.id}" <c:if test="${author.id == book.author.id}">selected</c:if>>${author.firstName} ${author.lastName}</option>
            </c:forEach>
        </select><br><br>

        <label for="category">Категория:</label><br>
        <select id="category" name="category" required>
            <c:forEach var="category" items="${listCategories}">
                <option value="${category.id}" <c:if test="${category.id == book.category.id}">selected</c:if>>${category.name}</option>
            </c:forEach>
        </select><br><br>

        <label for="year">Год издания:</label><br>
        <input type="number" id="year" name="year" value="${book.year}" min="1900" max="2100" required><br><br>

        <label for="isbn">ISBN:</label><br>
        <input type="text" id="isbn" name="isbn" value="${book.isbn}" required><br><br>

        <input type="submit" value="Обновить">
    </form>
</body>
</html>
<%@ include file="footer.jspf" %>
