package pt.ua.tqs.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "delivery")
public class Delivery {
    private long id;
    private Timestamp orderTime;
    private String storeName;
    private String storeAddress;
    private String storePhone;
    private String clientName;
    private String clientAddress;
    private String clientPhone;
    private String orderNote;
    private String riderName;
    private String riderPhone;
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

    @Column(name = "storeName", nullable = false)
    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    @Column(name = "storeAddress", nullable = false)
    public String getStoreAddress() { return storeAddress; }
    public void setStoreAddress(String storeAddress) { this.storeAddress = storeAddress; }

    @Column(name = "storePhone", nullable = false)
    public String getStorePhone() { return storePhone; }
    public void setStorePhone(String storePhone) { this.storePhone = storePhone; }

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

    @Column(name = "riderName", nullable = false)
    public String getRiderName() { return riderName; }
    public void setRiderName(String riderName) { this.riderName = riderName; }

    @Column(name = "riderPhone", nullable = false)
    public String getRiderPhone() { return riderPhone; }
    public void setRiderPhone(String riderPhone) { this.riderPhone = riderPhone; }

    @Column(name = "deliveryStatus", nullable = false)
    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    @Column(name = "deliveryDelayed", nullable = false)
    public boolean isDeliveryDelayed() { return deliveryDelayed; }
    public void setDeliveryDelayed(boolean deliveryDelayed) { this.deliveryDelayed = deliveryDelayed; }
}
