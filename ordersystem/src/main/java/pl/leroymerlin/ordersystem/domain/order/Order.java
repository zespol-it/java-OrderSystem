package pl.leroymerlin.ordersystem.domain.order;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;
    private String customerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order() {}

    public Order(UUID id, OrderStatus status, List<OrderItem> items, String customerId, LocalDateTime createdAt) {
        this.id = id;
        this.status = status;
        this.items = items;
        this.customerId = customerId;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    // gettery, settery, metody domenowe

    public UUID getId() { return id; }
    public OrderStatus getStatus() { return status; }
    public List<OrderItem> getItems() { return items; }
    public String getCustomerId() { return customerId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setStatus(OrderStatus status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }
} 