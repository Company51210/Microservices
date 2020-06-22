package altran.rentcloud.vehicleservice.service;

import altran.rentcloud.model.vehicle.Vehicle;
import altran.rentcloud.vehicleservice.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    //Debugger
    public static final Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle customer) {
        return vehicleRepository.save(customer);
    }

     @Override
    public Vehicle findById(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        log.info("Result of Find by Id method call:"+vehicle);
        if (vehicle.isPresent())
            return vehicle.get();
        else
            return new Vehicle();
    }
    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
}
