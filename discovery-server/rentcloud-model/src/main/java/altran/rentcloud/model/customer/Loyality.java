package altran.rentcloud.model.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loyalityPoint")
@Data
public class Loyality {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int transactionId;
/*    @ManyToOne
    @JoinColumn
    Customer customer;*/
    int point;
    Date lastDate;
}
