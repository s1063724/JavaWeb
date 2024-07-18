<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>喵喵商城</title>
</head>
<body>
    <h1>商品</h1>
    <table border="1">
        <thead>
            <tr>
                <th>商品編號</th>
                <th>商品名稱</th>
                <th>商品價錢</th>
                <th>商品描述</th>
                <th>商品照片</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td><img src="${product.imageUrl}" alt="${product.name}"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
