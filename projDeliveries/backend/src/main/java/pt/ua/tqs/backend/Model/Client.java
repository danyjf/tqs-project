package pt.ua.tqs.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    private String Name;
    private String Address;
    private String Phone;
    
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
