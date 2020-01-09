package ch.hesge.eshop.filters;

import ch.hesge.eshop.models.Product;
import ch.hesge.eshop.services.ProductService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public class RemoveAllFromCaddyFilter implements Filter {

    private ProductService productService;

    public RemoveAllFromCaddyFilter() {
    }

    @Inject
    public RemoveAllFromCaddyFilter(ProductService productService) {
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
        caddy.remove(product);
        request.getSession().setAttribute("caddy", caddy);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
