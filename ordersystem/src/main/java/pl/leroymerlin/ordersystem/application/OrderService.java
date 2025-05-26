package pl.leroymerlin.ordersystem.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leroymerlin.ordersystem.domain.order.Order;
import pl.leroymerlin.ordersystem.domain.order.OrderItem;
import pl.leroymerlin.ordersystem.domain.order.OrderRepository;
import pl.leroymerlin.ordersystem.domain.order.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(String customerId, List<OrderItem> items) {
        Order order = new Order(UUID.randomUUID(), OrderStatus.CREATED, items, customerId, LocalDateTime.now());
        return orderRepository.save(order);
    }

    public void changeStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        orderRepository.save(order);
    }

    public Order getOrder(UUID id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
} 