package ch.hesge.eshop.servlets;

import ch.hesge.eshop.models.Product;
import ch.hesge.eshop.services.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductsServlet extends HttpServlet {

    ProductService productService;

    public ProductsServlet() {
    }

    @Inject
    public ProductsServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        List<Product> products = productService.getProducts();

        req.setAttribute("productsList", products);

        req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, resp);
    }
}
