package ch.hesge.eshop.servlets;

import ch.hesge.eshop.models.Product;
import ch.hesge.eshop.services.DataValidatorService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class PaymentServlet extends HttpServlet {

    private DataValidatorService dataValidatorService;

    public PaymentServlet() {
    }

    @Inject
    public PaymentServlet(DataValidatorService dataValidatorService) {
        this.dataValidatorService = dataValidatorService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Product, Integer> contentCaddy = (Map<Product, Integer>) req.getSession().getAttribute("caddy");
        req.setAttribute("contentCaddy", contentCaddy);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/payment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (validateDataForPayment(req)) {
            req.getSession().setAttribute("caddy", new HashMap<>());
            String message = "Merci pour votre commande !";
            resp.sendRedirect(req.getContextPath() + "/products?message=" + URLEncoder.encode(message, StandardCharsets.UTF_8.name()));
        }

    }

    private boolean validateDataForPayment(HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String numberCard = req.getParameter("numberCard");
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            req.setAttribute("nameMessage", "Le nom est requis");
            return false;
        }
        if (!dataValidatorService.isValidEmail(email)) {
            req.setAttribute("numberCardMessage", "La carte de crédit est invalide");
            return false;
        }
        if (!dataValidatorService.isValidNumberCard(numberCard)) {
            req.setAttribute("emailMessage", "L'email est invalide");
            return false;
        }
        return true;
    }
}
