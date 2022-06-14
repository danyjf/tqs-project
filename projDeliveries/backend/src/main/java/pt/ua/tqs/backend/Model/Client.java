package pt.ua.tqs.backend.Model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    private long id;
    private String Name;
    private String Address;
    private String Phone;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "Name", nullable = false)
    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }

    @Column(name = "Address", nullable = false)
    public String getAddress() { return Address; }
    public void setAddress(String Address) { this.Address = Address; }

    @Column(name = "Phone", nullable = false)
    public String getPhone() { return Phone; }
    public void setPhone(String Phone) { this.Phone = Phone; }
}
