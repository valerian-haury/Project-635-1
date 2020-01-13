<div class="product-container">
    <a class="product-link" href="${pageContext.request.contextPath}/product/?id=${product.getID()}">
        <img class="product-background-img" src="${pageContext.request.contextPath}/img/products/${product.getUrlImg()}"  alt="${product.getName()}">
        <div class="product-name">
            <p class="product-name-text">${product.getName()}</p>
        </div>
    </a>
    <div class="product-price">
        <form action="${pageContext.request.contextPath}/caddy/add" method="post">
            <input type="hidden" name="id" value="${product.getID()}">
            <button class="product-add-button" type="submit">
                <p class="product-price-text">
                    ${String.format("%.2f",product.getPrice())} CHF
                </p>
                <img class="product-caddy-img" src="${pageContext.request.contextPath}/img/caddie.png"
                     alt="Checkout">
            </button>
        </form>
    </div>
</div>