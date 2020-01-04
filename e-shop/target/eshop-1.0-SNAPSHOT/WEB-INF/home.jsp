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
    <title>Accueil</title>
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
</div>
    <div class="home" style="background-image: url('${pageContext.request.contextPath}/img/home_background.jpg')">
        <div class="container">
            <a href="${pageContext.request.contextPath}/products">
                <div class="home-title"><h1>Welcome to e-shop !</h1></div>
            </a>
            <a href="${pageContext.request.contextPath}/products">
                <div class="home-description">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                    <p>Fusce finibus condimentum elit, sit amet ullamcorper orci fermentum quis. Mauris volutpat ante non neque semper placerat. Nunc in ex a ante rhoncus commodo. Phasellus auctor mauris vel aliquet lobortis. Fusce porta massa sed eros accumsan, nec aliquam mi luctus. Pellentesque et ex vitae purus vulputate pharetra.</p>
                </div>
            </a>
        </div>
        <div class="products-container">
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                for (Product p : products) {
            %>
            <jsp:include page="/product" flush="true">
                <jsp:param name="id" value="<%=p.getID()%>"/>
            </jsp:include>
            <%}%>
        </div>
    </div>
</body>
</html>
