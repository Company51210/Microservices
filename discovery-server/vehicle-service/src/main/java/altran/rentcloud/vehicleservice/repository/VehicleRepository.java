package altran.rentcloud.vehicleservice.repository;

import altran.rentcloud.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
