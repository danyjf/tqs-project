package shop.music.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String imageURL;
    private String name;
    private Float price;
    private String description;
    private Integer stock;
    private String category;

    public Product(){}

    public Product(String name, String imageURL, Float price, String description, Integer stock, String category){
        this.name=name;
        this.imageURL=imageURL;
        this.price=price;
        this.description=description;
        this.stock=stock;
        this.category=category;
    }

    public Integer getId() {
        return id;
    }

    @Column(name = "imageURL", nullable = false)
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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


}