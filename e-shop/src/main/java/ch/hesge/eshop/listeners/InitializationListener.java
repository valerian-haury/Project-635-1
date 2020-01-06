package ch.hesge.eshop.listeners;

import ch.hesge.eshop.models.Product;
import ch.hesge.eshop.services.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

public class InitializationListener  implements ServletContextListener{

    private ProductService productService;

    @Inject
    public InitializationListener(ProductService productService) {
        this.productService = productService;
    }


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.productService.persist(generateProducts());
    }



    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private List<Product> generateProducts() {
        List<Product> products = new ArrayList<>();

        products.add( new Product(
                "Product-1",
                24.90,
                "product_1.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));
        products.add( new Product(
                "Product-2",
                24.90,
                "product_2.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));
        products.add( new Product(
                "Product-3",
                299.900,
                "product_3.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));
        products.add( new Product(
                "Product-4",
                99.90,
                "product_2.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));
        products.add( new Product(
                "Product-5",
                59.90,
                "product_1.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));
        products.add( new Product(
                "Product-6",
                14.90,
                "product_3.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));
        products.add( new Product(
                "Product-7",
                89.90,
                "product_2.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));
        products.add( new Product(
                "Product-8",
                79.90,
                "product_3.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));        products.add( new Product(
                "Product-9",
                49.90,
                "product_1.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));        products.add( new Product(
                "Product-10",
                29.90,
                "product_2.jpg",
                "Sed porta condimentum ex in dictum. Vestibulum non nulla ut purus facilisis volutpat ultrices vel magna. Aenean viverra porttitor velit vel ultricies. Donec eu nibh ipsum. Proin varius sem non ligula dignissim, ut iaculis diam fermentum."
        ));

        return products;
    }




}
