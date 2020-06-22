package altran.rentcloud.model.vehicle;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    String model;
    String type;
    int year;
    String color;
    Double rentPrice;
}
