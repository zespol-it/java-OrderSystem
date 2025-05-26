package pl.leroymerlin.ordersystem.web;

import org.springframework.web.bind.annotation.*;
import pl.leroymerlin.ordersystem.application.OrderService;
import pl.leroymerlin.ordersystem.domain.order.Order;
import pl.leroymerlin.ordersystem.domain.order.OrderItem;
import pl.leroymerlin.ordersystem.domain.order.OrderStatus;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestParam String customerId, @RequestBody List<OrderItem> items) {
        return orderService.createOrder(customerId, items);
    }

    @PostMapping("/{orderId}/status")
    public Order changeStatus(@PathVariable UUID orderId, @RequestParam OrderStatus status) {
        Order order = orderService.getOrder(orderId);
        if (order != null) {
            orderService.changeStatus(order, status);
        }
        return order;
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable UUID orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
} 