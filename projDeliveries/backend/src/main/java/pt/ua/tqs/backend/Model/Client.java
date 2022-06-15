package pt.ua.tqs.backend.Model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    private long id;
    private String name;
    private String address;
    private String phone;
    
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
}
