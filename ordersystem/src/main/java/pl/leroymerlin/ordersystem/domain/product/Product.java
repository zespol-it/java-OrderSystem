package pl.leroymerlin.ordersystem.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private int availableQuantity;
    private double price;
    private String storeLocation;

    public Product() {}

    public Product(String id, String name, int availableQuantity, double price, String storeLocation) {
        this.id = id;
        this.name = name;
        this.availableQuantity = availableQuantity;
        this.price = price;
        this.storeLocation = storeLocation;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAvailableQuantity() { return availableQuantity; }
    public double getPrice() { return price; }
    public String getStoreLocation() { return storeLocation; }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
} 