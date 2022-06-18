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
 private String status;

 public Order(Integer user_id, Integer product_id, String status){
     this.userid = user_id;
     this.productid = product_id;
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

    @Column(name = "productid", nullable = false)
    public Integer getProductid() { return productid; }
    public void setProductid(Integer product_id) { this.productid = product_id; }

    @Column(name = "status", nullable = false)
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}