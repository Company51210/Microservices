package altran.rentcloud.model.customer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String dlNumber;
    private String zipcode;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Loyality.class)
    @JoinColumn(name = "loylity_fk",referencedColumnName = "id")
    private List<Loyality> loyalities;

}
