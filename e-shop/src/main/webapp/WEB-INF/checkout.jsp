<%@ page import="ch.hesge.eshop.models.Product" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Mota
  Date: 03.01.2020
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="icon" href="${pageContext.request.contextPath}/img/petshoplogo.ico" />
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/general.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/checkout.css">
</head>
<body>
<div class="container" >
    <table class="table">

        <%
            Double total = 0.0;
            Map<Product, Integer> contentCaddy = (Map<Product, Integer>) request.getAttribute("contentCaddy");
            for (Map.Entry<Product, Integer> rowCaddy : contentCaddy.entrySet()) {
                Double price = rowCaddy.getKey().getPrice() * rowCaddy.getValue();
                total += price;

        %>

        <tr class="row">
            <td>
                <div class="cell">
                    <img class="product-image"src="${pageContext.request.contextPath}/img/products/<%=rowCaddy.getKey().getUrlImg()%>"alt="<%=rowCaddy.getKey().getName()%>">
                    <%=rowCaddy.getKey().getName()%>
                </div>
            </td>
            <td>
                <div class="cell">
                    <div class="table-cell-container-button">
                        <form action="${pageContext.request.contextPath}/caddy/add" method="post">
                            <input type="hidden" name="id" value="<%=rowCaddy.getKey().getID()%>">
                            <button class="table-cell-button" type="submit">
                                <img class="image-put" src="${pageContext.request.contextPath}/img/plus.png">
                            </button>
                        </form>
                        <p class="product-number-text"><%=rowCaddy.getValue()%></p>
                        <form action="${pageContext.request.contextPath}/caddy/delete" method="post">
                            <input type="hidden" name="id" value="<%=rowCaddy.getKey().getID()%>">
                            <button class="table-cell-button" type="submit">
                                <img class="image-put" src="${pageContext.request.contextPath}/img/minus.png">
                            </button>
                        </form>
                    </div>
                </div>
            </td>
            <td>
                <div class="cell">
                    <form action="${pageContext.request.contextPath}/caddy/removeall" method="post">
                        <input type="hidden" name="id" value="<%=rowCaddy.getKey().getID()%>">
                        <button class="table-cell-button" type="submit">
                            <img class="image-put" src="${pageContext.request.contextPath}/img/trash.png">
                        </button>
                    </form>
                </div>
            </td>
            <td>
                <div class="cell">
                    CHF <%=String.format("%.2f", price)%>-
                </div>
            </td>
        </tr>
        <%}%>
    </table>
    <div class="container-total">
        <h2>Total</h2>
        <h2>CHF <%=String.format("%.2f", total)%>-</h2>
    </div>
    <div class="container-pay">
        <p class="backtoshop-button"><a class="back-link" href="${pageContext.request.contextPath}/products">Retour au shopping</a></p>
        <% if (contentCaddy.size() > 0) { %>
        <p><a class="pay-link" href="${pageContext.request.contextPath}/payment">Payer</a></p>
        <% } else {%>
        <p><a class="pay-link-disable">Payer</a></p>
        <% } %>
    </div>
</div>

</body>
</html>
