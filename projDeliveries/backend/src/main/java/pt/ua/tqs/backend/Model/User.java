package pt.ua.tqs.backend.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Set;
import java.util.HashSet;

@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "username")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "users")
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String userType;
    private Set<Delivery> deliveries;

    public User() {}

    public User(String username, String email, String password, String phone, String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
        this.deliveries = new HashSet<Delivery>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "username", nullable = false)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Column(name = "email", nullable = false)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Column(name = "password", nullable = false)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Column(name = "phone", nullable = false)
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Column(name = "userType", nullable = false)
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    @OneToMany(targetEntity = Delivery.class, fetch= FetchType.LAZY, mappedBy = "rider", cascade = CascadeType.ALL)
    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> del) {
        this.deliveries = del;
    }
    
    public void addDelivery(Delivery del) {
        this.deliveries.add(del);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
