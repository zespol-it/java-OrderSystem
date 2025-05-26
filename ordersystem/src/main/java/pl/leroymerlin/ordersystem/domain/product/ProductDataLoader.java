package pl.leroymerlin.ordersystem.domain.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            productRepository.save(new Product("P001", "Młotek", 100, 29.99, "Sklep A"));
            productRepository.save(new Product("P002", "Wkrętarka", 50, 199.99, "Sklep B"));
            productRepository.save(new Product("P003", "Farba biała 10L", 200, 89.99, "Sklep A"));
        }
    }
} 