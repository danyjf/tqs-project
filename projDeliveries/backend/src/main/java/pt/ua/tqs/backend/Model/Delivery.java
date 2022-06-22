package pt.ua.tqs.backend.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

@Entity
@Table(name = "delivery")
public class Delivery {
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Timestamp orderTime;
    private long orderId;
    private Store store;
    private Client client;
    private String orderNote;
    private User rider;
    private String deliveryStatus;
    private boolean deliveryDelayed;

    public Delivery(){}

    public Delivery(Timestamp orderTime, String orderNote){
        this.orderTime = orderTime;
        this.orderNote = orderNote;
        deliveryStatus = "Waiting for rider";
        deliveryDelayed = false;
    }

    public Delivery(long orderId,Timestamp orderTime, Store store, Client client, String orderNote) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.store = store;
        this.client = client;
        this.orderNote = orderNote;
        this.deliveryStatus = "Waiting for rider";
        this.deliveryDelayed = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "orderTime", nullable = false)
    public Timestamp getOrderTime() { return orderTime; }
    public void setOrderTime(Timestamp orderTime) { this.orderTime = orderTime; }

    //@OneToMany(targetEntity = Song.class, fetch= FetchType.LAZY, mappedBy = "album", cascade = CascadeType.ALL)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    public Client getClient(){
        return client;
    }
    public void setClient(Client c){
        this.client = c;
    }

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "store")
    public Store getStore(){
        return store;
    }
    public void setStore(Store s){
        this.store = s;
    }

    @Column(name = "orderNote", nullable = false)
    public String getOrderNote() { return orderNote; }
    public void setOrderNote(String orderNote) { this.orderNote = orderNote; }

    @Column(name = "orderId", nullable = false)
    public long getOrderId() { return orderId; }
    public void setOrderId(long orderId) { this.orderId = orderId; }

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "users")
    public User getRider(){
        return rider;
    }
    public void setRider(User r){
        this.rider = r;
    }

    @Column(name = "deliveryStatus", nullable = false)
    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    @Column(name = "deliveryDelayed", nullable = false)
    public boolean isDeliveryDelayed() { return deliveryDelayed; }
    public void setDeliveryDelayed(boolean deliveryDelayed) { this.deliveryDelayed = deliveryDelayed; }
}
