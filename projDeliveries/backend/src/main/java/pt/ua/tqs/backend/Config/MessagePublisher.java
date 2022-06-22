package pt.ua.tqs.backend.Config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@Service
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    public String publishMessage(@RequestBody CustomMessage message, String QUEUE) {
        MQConfig.setQUEUE("delivery_status/" + QUEUE);
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return "Message Published";
    }
}
