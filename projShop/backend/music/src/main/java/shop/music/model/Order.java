package shop.music.model;

import java.sql.Timestamp;
import javax.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order{
 private long id;
 private Integer userid;
 private Integer productid;

 public Order(Integer user_id, Integer product_id){
     this.userid = user_id;
     this.productid = product_id;
 }

 public Order() {

 }

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id", nullable = false)
 public long getId() { return id; }
 public void setId(long id) { this.id = id; }

 @Column(name = "userid", nullable = false)
 public Integer getUserid() { return userid; }
 public void setUserid(Integer userid) { this.userid = userid; }

 @Column(name = "productid", nullable = false)
 public Integer getProductid() { return productid; }
 public void setProductid(Integer product_id) { this.productid = product_id; }


}
/** Approach didn't work
@Entity
@Table(name = "Orderr")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Timestamp date;
    private Float price;
    private Integer num_products;
    private String state;

    private Integer user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orders")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();


    public Order() {
    }

    public Order(Integer id, Timestamp date, Float price, Integer num_products, String state, Integer user, List<Product> products) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.num_products = num_products;
        this.state = state;
        this.user = user;
        this.products = products;
    }

    public Product addProduct(Product prdct){
        this.price += prdct.getPrice();
        this.num_products += 1;
        this.products.add(prdct);
        return prdct;
    }

    public Product removeProduct(Product prdct){
        this.price -= prdct.getPrice();
        this.num_products -= 1;
        this.products.remove(prdct);
        return prdct;
    }

    public Integer getId() {
        return id;
    }

    @Column(name="state", nullable = false)
    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state=state;
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

    @Column(name = "userId", nullable = false)
    public Integer getUserId() {
        return user;
    }
    public void setUser(Integer user) {
        this.user = user;
    }

    @Column(name = "products", nullable = false)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
    
}**/