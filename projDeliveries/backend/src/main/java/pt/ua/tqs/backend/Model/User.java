package pt.ua.tqs.backend.Model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String type;

    public User(){}

    public User(String email, String username, String password, String phone, String type) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.type = type;
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

    @Column(name = "type", nullable = false)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
