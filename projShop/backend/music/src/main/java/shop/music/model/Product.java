package shop.music.model;

import javax.persistence.*;
import java.util.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
public class Product {
    private long id;
    private String imageURL;
    private String productName;
    private String description;
    private String price;
    private String stock;

    public Product(String imageURL, String productName, String description, String price, String stock) {
        this.imageURL = imageURL;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "imageURL", nullable = false)
    public String getImageURL() { return imageURL; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    @Column(name = "name", nullable = false)
    public String getName() { return productName; }
    public void setName(String productName) { this.productName = productName; }

    @Column(name = "description", nullable = false)
    public String getDescription() { return description; }
    public void setDescription(String Description) { this.description = description; }

    @Column(name = "price", nullable = false)
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    @Column(name = "stock", nullable = false)
    public String getStock() { return stock; }
    public void setStock(String stock) { this.stock = stock; }
}
/**
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;
    private Float price;
    private String description;
    private Integer stock;
    private String category;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "OrderProduct",joinColumns = { @JoinColumn(name = "product.id") },inverseJoinColumns = { @JoinColumn(name = "order.id") })
    private List<Order> orders = new ArrayList<>();

    public Product(){}

    public Product(String name, Float price, String description, Integer stock, String category, Manager manager){
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
        this.category=category;
        this.manager=manager;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price", nullable = false)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "stock", nullable = false)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    
}
**/