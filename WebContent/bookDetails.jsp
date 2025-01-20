<%@ include file="header.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Детали книги</title>
</head>
<body>
    <h1>Детали книги</h1>
    <p><strong>Название:</strong> ${book.title}</p>
    <p><strong>Автор:</strong> ${book.author.firstName} ${book.author.lastName}</p>
    <p><strong>Категория:</strong> ${book.category.name}</p>
    <p><strong>Год издания:</strong> ${book.year}</p>
    <p><strong>ISBN:</strong> ${book.isbn}</p>
    <br>
    <a href="BookController?action=list">Вернуться к списку книг</a>
</body>
</html>
<%@ include file="footer.jspf" %>
