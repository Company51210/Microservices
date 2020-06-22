package altran.rentcloud.model.rent;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rent")
@Data
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int rentId;
    int customerId;
    int vehicleId;
    Date rentFrom;
    Date rentTill;
    String location;

}
