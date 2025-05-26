package pl.leroymerlin.ordersystem.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.leroymerlin.ordersystem.domain.order.OrderRepository;
import pl.leroymerlin.ordersystem.domain.order.Order;
import pl.leroymerlin.ordersystem.domain.order.OrderItem;
import pl.leroymerlin.ordersystem.domain.order.OrderStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private OrderRepository orderRepository;
    private OrderService service;

    @BeforeEach
    void setUp() {
        orderRepository = Mockito.mock(OrderRepository.class);
        Mockito.when(orderRepository.save(Mockito.any())).thenAnswer(i -> i.getArguments()[0]);
        service = new OrderService(orderRepository);
    }

    @Test
    void shouldCreateOrderWithStatusCreated() {
        Order order = service.createOrder("customer1", List.of(new OrderItem("prod1", 2, 10.0)));
        assertNotNull(order.getId());
        assertEquals(OrderStatus.CREATED, order.getStatus());
        assertEquals("customer1", order.getCustomerId());
        assertEquals(1, order.getItems().size());
    }

    @Test
    void shouldChangeOrderStatus() {
        Order order = service.createOrder("customer1", List.of(new OrderItem("prod1", 2, 10.0)));
        service.changeStatus(order, OrderStatus.RESERVED);
        assertEquals(OrderStatus.RESERVED, order.getStatus());
    }
} 