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
 private List<Product> products;
 private Integer productid;
 private String status;

 public Order(Integer user_id, List<Product> products, String status){
     this.userid = user_id;
     this.products = products;
     this.status = status;
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

    @Column(name = "productid", nullable = true)
    public Integer getProductid() { return productid; }
    public void setProductid(Integer productid) { this.productid = productid; }

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    @Column(name = "status", nullable = false)
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}