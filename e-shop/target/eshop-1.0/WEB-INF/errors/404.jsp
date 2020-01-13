<%--
  Created by IntelliJ IDEA.
  User: haury
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>404</title>

    <link rel="icon" href="${pageContext.request.contextPath}/img/petshoplogo.ico" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/general.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/caddy.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menubar.css">
</head>
<body>
<jsp:include page="/menubar"/>
<div class="container">
    <img src="${pageContext.request.contextPath}/img/404.gif">
    <h3>La page recherchée n'exise pas.</h3>
    <p><a class="back-link" href="${pageContext.request.contextPath}/products">Retour au shopping</a></p>
</div>
</body>
</html>
