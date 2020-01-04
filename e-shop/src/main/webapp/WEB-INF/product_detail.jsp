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
<% Product product = (Product)request.getAttribute("product"); %>
<html>
<head>
    <title><%=product.getName()%> - détail</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="icon" href="${pageContext.request.contextPath}/img/petshoplogo.ico" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/general.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/caddy.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menubar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product_detail.css">
</head>
<body>
<div class="top-bar">
    <jsp:include page="/menubar"/>
</div>
<div class="container">
    <div class="product-detail-container">
        <h1 class="name">${product.getName()}</h1>
        <p>
            <%=product.getDescription().replace("\n", "<br />\n")%>
        </p>
        <div class="product-detail-price">
            <form action="${pageContext.request.contextPath}/caddy/add" method="post">
                <input type="hidden" name="id" value="${product.getID()}">
                <button class="product-price-button" type="submit">
                    <p class="product-price-text">
                        CHF ${String.format("%.2f",product.getPrice())}-
                    </p>
                    <img class="product-caddy-img"
                         src="${pageContext.request.contextPath}/img/caddie.png" alt="Checkout">
                </button>
            </form>
        </div>
    </div>
    <div class="product-img-container">
        <img class="product-image"
             src="${pageContext.request.contextPath}/img/products/${product.getUrlImg()}"
             alt="${product.getName()}">
    </div>
</div>

</body>
</html>
