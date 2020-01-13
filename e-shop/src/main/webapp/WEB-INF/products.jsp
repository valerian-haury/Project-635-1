<%--
  Created by IntelliJ IDEA.
  User: Haury
  Date: 26.12.2019
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ch.hesge.eshop.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="icon" href="${pageContext.request.contextPath}/img/petshoplogo.ico" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/general.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/caddy.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menubar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product.css">
</head>
<body>
<div class="top-bar">
    <jsp:include page="/menubar"/>
    <%
        String message = request.getParameter("message");
        if (message != null && !message.isEmpty()) {
    %>
    <div class="banner">
        <h2 class="banner-text">
            <%= message %>
        </h2>
    </div>
    <% } %>
</div>

<div class="container">
    <h1>Liste des Produits</h1>
    <div class="products-container">
        <%
            List<Product> products = (List<Product>) request.getAttribute("productsList");
            for (Product product : products) {
        %>
        <jsp:include page="/product">
            <jsp:param name="id" value="<%=product.getID()%>"/>
            <jsp:param name="full" value="false"/>
        </jsp:include>

        <%}%>

    </div>
</div>

</body>
</html>
