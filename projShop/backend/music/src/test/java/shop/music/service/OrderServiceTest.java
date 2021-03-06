package shop.music.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import shop.music.model.Order;
import shop.music.model.Product;
import shop.music.model.User;
import shop.music.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderService service;

    @Test
    void whenGetOrderByUserId_thenUserOrdersShouldBeReturned() {
        List<Product> products = new ArrayList<>();
        Order order = new Order(1, products, "status");
        Order order2 = new Order(1, products, "status");

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order2);

        Mockito.when(repository.findOrderByUserid(1)).thenReturn(orders);

        List<Order> fromDb = service.getUserOrders(1);

        assertThat(fromDb).isEqualTo(orders);

        verify(repository, times(1)).findOrderByUserid(Mockito.anyInt());
    }

    @Test
    void whenGetAllOrders_thenAllOrdersShouldBeReturned() {
        Order order1 = new Order();
        Order order2 = new Order();

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        Mockito.when(repository.findAll()).thenReturn(orders);

        List<Order> fromDb = service.getAll();

        assertThat(fromDb).isEqualTo(orders);

        verify(repository, times(1)).findAll();
    }

    @Test
    void whenUpdateOrderStatus_thenUpdatedOrderShouldBeReturned(){
        List<Product> products = new ArrayList<>();
        Order order = new Order(1, products, "status");
        String expected = "New Status";

        Mockito.when(repository.findById(1)).thenReturn(order);

        Order fromDb = service.updateStatus(1, expected);

        assertThat(fromDb.getStatus()).isEqualTo(expected);

    }
}
