package altran.rentcloud.rentservice.controller;

import altran.rentcloud.model.rent.Rent;
import altran.rentcloud.rentservice.model.Response;
import altran.rentcloud.rentservice.model.SimpleResponse;
import altran.rentcloud.rentservice.service.RentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Author:Vivek Kumar
 * Date:21-06-2020
 * Link:http://localhost:9090/services/rents
 */
@RestController
@RequestMapping("/services/rents")
public class RentController {

    //Debugger
    public static final Logger log = LoggerFactory.getLogger(RestController.class);

    @Autowired
    RentService rentService;

    @PostMapping
    public Rent save(@RequestBody Rent rent) {
        return rentService.save(rent);
    }

    @GetMapping(value = "/{id}",produces = "application/json", consumes = "application/json")
    public Response getRent(@PathVariable int id, @RequestParam(required = false) String type) {
        if(type==null)
            return  new SimpleResponse(rentService.findById(id));
        else
            return rentService.findDetailResponse(id);
    }

    @GetMapping(value = "/list")
    public List<Rent> getAllRents() {
        return rentService.findAll();
    }
}
