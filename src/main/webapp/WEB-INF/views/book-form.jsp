<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${book.id == null ? 'Add New' : 'Edit'} Book | Library Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group input[type="submit"] {
            background-color: #0066cc;
            color: white;
            cursor: pointer;
            border: none;
        }
        .form-group input[type="submit"]:hover {
            background-color: #0052a3;
        }
        .button {
            display: inline-block;
            padding: 8px 16px;
            background-color: #555;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 5px;
            font-size: 14px;
        }
        .button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>${book.id == null ? 'Add New' : 'Edit'} Book</h1>

        <c:choose>
            <c:when test="${book.id == null}">
                <form action="/books" method="post">
                    <div class="form-group">
                        <label for="title">Title:</label>
                        <input type="text" id="title" name="title" value="${book.title}" required>
                    </div>
                    <div class="form-group">
                        <label for="genre">Genre:</label>
                        <input type="text" id="genre" name="genre" value="${book.genre}" required>
                    </div>
                    <div class="form-group">
                        <label for="author">Author:</label>
                        <select id="author" name="author.id" required>
                            <option value="">-- Select Author --</option>
                            <c:forEach items="${authors}" var="author">
                                <option value="${author.id}" ${book.author.id == author.id ? 'selected' : ''}>${author.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Add Book">
                    </div>
                </form>
            </c:when>
            <c:otherwise>
                <form action="/books/${book.id}" method="post">
                    <div class="form-group">
                        <label for="title">Title:</label>
                        <input type="text" id="title" name="title" value="${book.title}" required>
                    </div>
                    <div class="form-group">
                        <label for="genre">Genre:</label>
                        <input type="text" id="genre" name="genre" value="${book.genre}" required>
                    </div>
                    <div class="form-group">
                        <label for="author">Author:</label>
                        <select id="author" name="author.id" required>
                            <option value="">-- Select Author --</option>
                            <c:forEach items="${authors}" var="author">
                                <option value="${author.id}" ${book.author.id == author.id ? 'selected' : ''}>${author.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Update Book">
                    </div>
                </form>
            </c:otherwise>
        </c:choose>

        <a href="/books" class="button">Back to Books</a>
    </div>
</body>
</html>