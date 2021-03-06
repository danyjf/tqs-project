package pt.ua.tqs.backend.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.HashSet;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "store")
public class Store {
	private long id;
    private String name;
    private String address;
    private String phone;
    @JsonIgnore
    private Set<Delivery> deliveries;

    public Store(){}

    public Store(String phone){
        this.phone = phone;
    }

    public Store(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.deliveries = new HashSet<Delivery>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "Name", nullable = false)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name = "Address", nullable = false)
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Column(name = "Phone", nullable = false)
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @OneToMany(targetEntity = Delivery.class, fetch= FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> del) {
        this.deliveries = del;
    }
    
    public void addDelivery(Delivery del) {
        this.deliveries.add(del);
    }
}
