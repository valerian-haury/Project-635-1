package ch.hesge.eshop.servlets;

import ch.hesge.eshop.models.Product;
import ch.hesge.eshop.services.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/*")
public class ProductDetailServlet extends HttpServlet {

    ProductService productService;

    @Inject
    public ProductDetailServlet(ProductService productService) {
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));

        Product product = productService.getProduct(id);
        req.setAttribute("product", product);

        req.getRequestDispatcher("/WEB-INF/product_detail.jsp").forward(req, resp);
    }
}
