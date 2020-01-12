package ch.hesge.eshop.servlets;

import ch.hesge.eshop.models.Product;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Product, Integer> contentCaddy = (Map<Product, Integer>) req.getSession().getAttribute("caddy");
        req.setAttribute("contentCaddy", contentCaddy);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(req, resp);
    }
}
