<%@ page import="ch.hesge.eshop.models.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Mota
  Date: 03.01.2020
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="icon" href="${pageContext.request.contextPath}/img/petshoplogo.ico" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/general.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/payments.css">
</head>
<body>
<div class="container">
    <div class="container-form">
        <form class="form" action="${pageContext.request.contextPath}/payment" method="post">
            <div class="caddie">
                <table class="table">
                    <%
                        double total = 0.0;
                        Map<Product, Integer> contentCaddy = (Map<Product, Integer>) request.getAttribute("contentCaddy");
                        for (Map.Entry<Product, Integer> rowCaddy : contentCaddy.entrySet()) {
                            double price = rowCaddy.getKey().getPrice() * rowCaddy.getValue();
                            total += price;
                    %>
                    <tr class="row">
                        <td>
                            <div class="cell"><%=rowCaddy.getKey().getName()%>
                            </div>
                        </td>
                        <td>
                            <div class="cell"><%=rowCaddy.getValue()%>
                            </div>
                        </td>
                        <td>
                            <div class="cell">CHF <%=String.format("%.2f", price)%>
                            </div>
                        </td>
                    </tr>

                    <%}%>
                </table>
                <div class="container-total">
                    <h3>Total</h3>
                    <h3>CHF <%=String.format("%.2f", total)%>-</h3>
                </div>

            </div>
            <div class="container-input">
                <div class="field">
                    <label>Nom-prénom propriétaire : </label>
                    <div class="input">
                        <input name="name" type="text" placeholder="Nom-prénom" required autofocus autocomplete="off"
                               value="${name}"/>
                        <p class="red">${nameMessage}</p>
                    </div>
                </div>

                <div class="field">
                    <label>Email :</label>
                    <div class="input">
                        <input name="email" type="email" placeholder="Email" required autocomplete="off"
                               value="${email}"/>
                        <p class="red">${emailMessage}</p>
                    </div>
                </div>

                <div class="field">
                    <label>N° carte de crédit :</label>
                    <div class="input">
                        <input name="numberCard" type="text" placeholder="N° carte de crédit" minlength="16" maxlength="16"
                               required autocomplete="off" value="${numberCard}"/>
                        <p class="red">${numberCardMessage}</p>
                    </div>
                </div>

                <div class="field">
                    <label>Date d'expiration :</label>
                    <div class="field-month-year">
                        <div class="input">
                            <input name="month" type="number" placeholder="Mois" min="1" max="12" required
                                   autocomplete="off" value="${month}"/>
                            <p class="red">${monthMessage}</p>
                        </div>
                        <div class="input">
                            <input name="year" type="number" placeholder="Année" min=<%=request.getAttribute("yearOfUse")%> required
                                   autocomplete="off" value="${year}"/>
                            <p class="red">${yearMessage}</p>
                        </div>
                    </div>
                </div>

                <div class="container-order">
                    <% if (contentCaddy.size() > 0) { %>
                    <button class="pay-link" type="submit">Commander</button>
                    <% } else {%>
                    <input type="hidden" required>
                    <p class="pay-link-disable">Commander</p>
                    <% } %>
                </div>
            </div>

        </form>
    </div>
    <div class="container-back">
        <p><a class="back-link" href="${pageContext.request.contextPath}/products">Retour au shopping</a></p>
    </div>
</div>
</body>
</html>
