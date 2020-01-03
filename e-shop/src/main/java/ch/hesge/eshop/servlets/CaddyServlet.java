package ch.hesge.eshop.servlets;


import ch.hesge.eshop.models.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;


@WebServlet("/caddy/*")
public class CaddyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Product, Integer> caddy = (Map<Product, Integer>) req.getSession().getAttribute("caddy");
        //req.getSession().setAttribute("nbProducts", getNumberProduct(caddy));
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/caddy.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /*private int getNumberProduct(Map<Product, Integer> caddy){
        List<Integer> values = new ArrayList<>(caddy.values());
        int sum = 0;
        for (Integer value: values) {
            sum += value;
        }
        return sum;
    }*/

}


