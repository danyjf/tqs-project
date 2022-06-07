package ua.tqs.shop.backend.model;
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
