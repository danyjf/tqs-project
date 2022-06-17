package shop.music.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import shop.music.model.Order;
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
        Order order = new Order(1,2);
        Order order2 = new Order(1,2);

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
        Order order1 = new Order(1,2);
        Order order2 = new Order(1,2);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        Mockito.when(repository.findAll()).thenReturn(orders);

        List<Order> fromDb = service.getAll();

        assertThat(fromDb).isEqualTo(orders);

        verify(repository, times(1)).findAll();
    }


}
