package shop.music.model;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private boolean state;
    private Timestamp date;
    private String method;
    private Float amount;
    private Integer nif;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Transaction(){}


    public Transaction(boolean state, String method, Float amount, Integer nif){
        this.state=state;
        this.date = new Timestamp(System.currentTimeMillis());
        this.method=method;
        this.amount=amount;
        this.nif=nif;
    }

    @Column(name = "state", nullable = false)
    public boolean isState() {
        return state;
    }


    public void setState(boolean state) {
        this.state = state;
    }

    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }


    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Column(name = "method", nullable = false)
    public String getMethod() {
        return method;
    }


    public void setMethod(String method) {
        this.method = method;
    }

    @Column(name = "amount", nullable = false)
    public Float getAmount() {
        return amount;
    }


    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Column(name = "nif", nullable = false)
    public Integer getNif() {
        return nif;
    }


    public void setNif(Integer nif) {
        this.nif = nif;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    

    
    
}
