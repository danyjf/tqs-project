package pt.ua.tqs.backend.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class CustomMessage {

    private String orderId;
    private String status;

    public CustomMessage(String orderId, String status){
        this.orderId = orderId;
        this.status = status;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public String getStatus(){
        return this.status = status;
    }

}