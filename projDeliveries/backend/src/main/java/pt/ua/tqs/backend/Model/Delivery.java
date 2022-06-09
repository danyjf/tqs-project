package pt.ua.tqs.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "delivery")
public class Delivery {
    private long id;
    private Timestamp orderTime;
    private Store store;
    private Client client;
    private String orderNote;
    private User rider;
    private String deliveryStatus;
    private boolean deliveryDelayed;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "orderTime", nullable = false)
    public Timestamp getOrderTime() { return orderTime; }
    public void setOrderTime(Timestamp orderTime) { this.orderTime = orderTime; }

    //store aqui, relação 1 to many

    //client aqui, 1 to many

    @Column(name = "orderNote", nullable = false)
    public String getOrderNote() { return orderNote; }
    public void setOrderNote(String orderNote) { this.orderNote = orderNote; }

    //Rider aqui, 1 to Many

    @Column(name = "deliveryStatus", nullable = false)
    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    @Column(name = "deliveryDelayed", nullable = false)
    public boolean isDeliveryDelayed() { return deliveryDelayed; }
    public void setDeliveryDelayed(boolean deliveryDelayed) { this.deliveryDelayed = deliveryDelayed; }
}
