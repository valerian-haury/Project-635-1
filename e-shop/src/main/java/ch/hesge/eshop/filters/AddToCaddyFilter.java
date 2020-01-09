package ch.hesge.eshop.filters;

import ch.hesge.eshop.models.Product;
import ch.hesge.eshop.services.ProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public class AddToCaddyFilter implements Filter {

    private ProductService productService;

    public AddToCaddyFilter() {
    }

    @Inject
    public AddToCaddyFilter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Product product = productService.getProduct(Integer.parseInt(request.getParameter("id")));
        Map<Product, Integer> caddy = (Map<Product, Integer>) request.getSession().getAttribute("caddy");
        if (caddy.containsKey(product)) {
            caddy.put(product, caddy.get(product) + 1);
        } else {
            caddy.put(product, 1);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
