package ua.tqs.shop.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order")
public class Order {
    private long id;
    private Timestamp orderTime;
    private String clientName;
    private String clientAddress;
    private String clientPhone;
    private String orderNote;
    private String orderStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "orderTime", nullable = false)
    public Timestamp getOrderTime() { return orderTime; }
    public void setOrderTime(Timestamp orderTime) { this.orderTime = orderTime; }

    @Column(name = "clientName", nullable = false)
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    @Column(name = "clientAddress", nullable = false)
    public String getClientAddress() { return clientAddress; }
    public void setClientAddress(String clientAddress) { this.clientAddress = clientAddress; }

    @Column(name = "clientPhone", nullable = false)
    public String getClientPhone() { return clientPhone; }
    public void setClientPhone(String clientPhone) { this.clientPhone = clientPhone; }

    @Column(name = "orderNote", nullable = false)
    public String getOrderNote() { return orderNote; }
    public void setOrderNote(String orderNote) { this.orderNote = orderNote; }

    @Column(name = "orderStatus", nullable = false)
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
}