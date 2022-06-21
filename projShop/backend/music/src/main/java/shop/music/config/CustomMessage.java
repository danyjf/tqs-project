package shop.music.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessage {

    private String orderId;
    private String status;
    public String getOrderId() {
        return this.orderId;
    }
    public String getStatus() {
        return this.status;
    }



}