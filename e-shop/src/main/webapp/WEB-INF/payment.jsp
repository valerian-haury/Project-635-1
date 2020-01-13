<%--
  Created by IntelliJ IDEA.
  User: Mota
  Date: 03.01.2020
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <div class="container-total">
                    <h3>Total</h3>
                    <h3>CHF <c:out value="${sessionScope.totalPrice}"/></h3>
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
                            <input name="year" type="number" placeholder="Année" min=<c:out value="${sessionScope.yearOfUse}"/> required
                                   autocomplete="off" value="${year}"/>
                            <p class="red">${yearMessage}</p>
                        </div>
                    </div>
                </div>

                <div class="container-order">
                    <c:choose>
                        <c:when test="${sessionScope.totalPrice>0}">
                            <button class="pay-link" type="submit">Commander</button>
                        </c:when>
                        <c:when test="${sessionScope.totalPrice==0}">
                            <input type="hidden" required>
                            <p class="pay-link-disable">Commander</p>
                        </c:when>
                    </c:choose>
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
