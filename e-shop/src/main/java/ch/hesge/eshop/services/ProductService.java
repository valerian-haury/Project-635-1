package ch.hesge.eshop.services;

import ch.hesge.eshop.models.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ProductService {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getProducts() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        cq.from(Product.class);

        TypedQuery<Product> tq = em.createQuery(cq);
        List<Product> products = tq.getResultList();
        return products;
    }

    public List<Product> getProducts(int size) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        cq.from(Product.class);

        TypedQuery<Product> tq = em.createQuery(cq).setMaxResults(size);
        List<Product> products = tq.getResultList();
        return products;
    }

    public Product getProduct(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    @Transactional
    public void persistProducts(List<Product> products) {
        for (Product product : products) {
            em.persist(product);
        }
    }
}
