package pl.leroymerlin.ordersystem.domain.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.leroymerlin.ordersystem.domain.product.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class OrderDataLoader implements CommandLineRunner {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderDataLoader(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (orderRepository.count() == 0) {
            for (int i = 1; i <= 10; i++) {
                var items = List.of(
                    new OrderItem("P001", 2, 29.99),
                    new OrderItem("P002", 1, 199.99)
                );
                var order = new Order(
                    UUID.randomUUID(),
                    OrderStatus.CREATED,
                    items,
                    "user",
                    LocalDateTime.now().minusDays(10 - i)
                );
                orderRepository.save(order);
            }
        }
    }
} 