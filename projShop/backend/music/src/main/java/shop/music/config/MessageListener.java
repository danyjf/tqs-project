package shop.music.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.music.model.Order;
import shop.music.service.OrderService;

@Component
public class MessageListener {
    @Autowired
    private OrderService service;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println(message);
        long order_id = Long.parseLong(message.getOrderId());
        String status = message.getStatus();

        Order order = service.updateStatus(order_id, status);
    }

}