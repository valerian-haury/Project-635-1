package ch.hesge.eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    private Double price;
    private String urlImg;
    private String description;

    public Product() {
    }

    public Product(String name, Double price, String urlImg, String description) {
        this.name = name;
        this.price = price;
        this.urlImg = urlImg;
        this.description = description;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getUrlImg() {
        return urlImg;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
