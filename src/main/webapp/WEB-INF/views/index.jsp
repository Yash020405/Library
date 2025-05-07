<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
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
        .card {
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 15px;
            margin-bottom: 20px;
        }
        .card h2 {
            margin-top: 0;
            color: #0066cc;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #0066cc;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 10px;
            margin-bottom: 10px;
        }
        .button:hover {
            background-color: #0052a3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Library Management System</h1>
        
        <div class="card">
            <h2>Manage Authors</h2>
            <p>View, add, edit, and manage author information.</p>
            <a href="/authors" class="button">View All Authors</a>
            <a href="/authors/new" class="button">Add New Author</a>
        </div>
        
        <div class="card">
            <h2>Manage Books</h2>
            <p>View, add, edit, and manage book information.</p>
            <a href="/books" class="button">View All Books</a>
            <a href="/books/new" class="button">Add New Book</a>
        </div>
    </div>
</body>
</html>