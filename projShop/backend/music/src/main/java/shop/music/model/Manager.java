package shop.music.model;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String username;
    private String fullname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Manager() {
    }

    public Manager(String username, String fullname, String email, String password) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "fullname", nullable = false)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getProducts(){
        return this.products;
    }


    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", fullname='" + getFullname() + "'" +
                ", email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

}

