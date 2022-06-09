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
    private String category;
    private String price;
    private String stock;

    public Product(String imageURL, String productName, String description,String category, String price, String stock) {
        this.imageURL = imageURL;
        this.productName = productName;
        this.description = description;
        this.category = category;
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
    public void setDescription(String description) { this.description = description; }

    @Column(name = "category", nullable = false)
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    @Column(name = "price", nullable = false)
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    @Column(name = "stock", nullable = false)
    public String getStock() { return stock; }
    public void setStock(String stock) { this.stock = stock; }
}