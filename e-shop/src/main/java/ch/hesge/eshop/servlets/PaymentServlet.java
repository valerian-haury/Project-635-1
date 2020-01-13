package ch.hesge.eshop.servlets;

import ch.hesge.eshop.models.Product;
import ch.hesge.eshop.services.DataValidatorService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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
        String yearOfUse = String.valueOf(LocalDate.now().getYear());
        req.setAttribute("contentCaddy", contentCaddy);
        req.setAttribute("yearOfUse", yearOfUse);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/payment.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (validateDataForPayment(req)) {
            req.getSession().setAttribute("caddy", new HashMap<>());
            String message = "Merci pour votre commande !";
            resp.sendRedirect(req.getContextPath() + "/products?message=" + message);

        } else {
            doGet(req, resp);
        }

    }

    private boolean validateDataForPayment(HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String numberCard = req.getParameter("numberCard");
        Boolean validName = true;
        Boolean validEmail = true;
        Boolean validCard = true;

        if (!dataValidatorService.isInvalidName(name)) {
            req.setAttribute("nameMessage", "Le nom est requis");
            validName = false;
        }
        if (!dataValidatorService.isInvalidEmail(email)) {
            req.setAttribute("emailMessage", "L'email est invalide");
            validEmail = false;
        }
        if (!dataValidatorService.isInvalidNumberCard(numberCard)) {
            req.setAttribute("numberCardMessage", "La carte de crédit est invalide");
            validCard = false;
        }
        return (validName && validEmail && validCard);
    }
}
