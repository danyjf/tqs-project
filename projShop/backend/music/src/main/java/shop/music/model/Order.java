package shop.music.model;

import java.sql.Timestamp;
import javax.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Timestamp date;
    private Float price;
    private Integer num_products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orders")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    @OneToOne(mappedBy = "id") //mappedBy "order" was getting error
    private Transaction transaction;

    public Order() {
    }

    public Order(Float price, int num_products, User user) {
        this.price = price;
        this.num_products = num_products;
        this.user = user;
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public Integer getId() {
        return id;
    }

    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Column(name = "price", nullable = false)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column(name = "num_products", nullable = false)
    public Integer getNum_products() {
        return num_products;
    }

    public void setNum_products(Integer num_products) {
        this.num_products = num_products;
    }

    public Integer getUserId() {
        return user.getId();
    }

    // public User getUser() {
    //     return user;
    // }

    public void setUser(User user) {
        this.user = user;
    }    

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }    

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", price='" + getPrice() + "'" +
                ", num_products='" + getNum_products() + "'" +
                ", user_id='" + getUserId() + "'" +
                ", date='" + getDate() + "'" +
                ", products='" + getProducts()  +"'" +
                "}";
    }
    
}
