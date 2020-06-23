package altran.rentcloud.vehicleservice.controller;

import altran.rentcloud.model.vehicle.Vehicle;
import altran.rentcloud.vehicleservice.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
/**
 * Author:Vivek Kumar
 * Date:21-06-2020
 * Link: http://localhost:9192/services/vechiles
 */
@RestController
@RequestMapping("/services/vehicles")
public class VehicleController {

    //Debugger
    public static final Logger log = LoggerFactory.getLogger(VehicleController.class);
    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @GetMapping(value = "/{id}")
    public Vehicle getVehicle(@PathVariable int id)
    {
        log.info("request came on "+LocalDateTime.now());
        return vehicleService.findById(id);
    }

    @GetMapping(value = "/list")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAll();
    }

}
