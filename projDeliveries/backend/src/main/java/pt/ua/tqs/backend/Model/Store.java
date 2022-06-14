package pt.ua.tqs.backend.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "store")
public class Store {
	
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
