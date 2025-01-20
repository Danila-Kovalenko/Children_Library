<%@ include file="header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список книг</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <h1>Список книг</h1>
    <table>
        <tr>
            <th>Название</th>
            <th>Автор</th>
            <th>Категория</th>
            <th>Год</th>
            <th>ISBN</th>
            <th>Действия</th>
        </tr>
        <c:forEach var="book" items="${listBooks}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author.firstName} ${book.author.lastName}</td>
                <td>${book.category.name}</td>
                <td>${book.year}</td>
                <td>${book.isbn}</td>
                <td>
                    <a href="BookController?action=edit&id=${book.id}">Редактировать</a>
                    <a href="BookController?action=delete&id=${book.id}" onclick="return confirm('Вы уверены, что хотите удалить эту книгу?')">Удалить</a>
                    <a href="BookController?action=details&id=${book.id}">Подробнее</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
<%@ include file="footer.jspf" %>
