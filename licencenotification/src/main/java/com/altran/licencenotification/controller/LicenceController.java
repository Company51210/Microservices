/*
  Created by  : Vivek Kumar
  Created on  : 18/06/2020
  Purpose     : Controller Class.
 */
package com.altran.licencenotification.controller;

import com.altran.licencenotification.model.User;
import com.altran.licencenotification.service.LicenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/licence")
public class LicenceController {

    //Logger
    public static final Logger log = LoggerFactory.getLogger(LicenceController.class);

    @Autowired
    LicenceService licenceService;

    //Get All registered User
    @GetMapping("/get")
    public List<User> getAll(){
        log.info("----------Get All User API-----------");
        return licenceService.get();
    }
    //Get All registered User By Id.
    @GetMapping("/{userId}")
    public User getById(@PathVariable Long userId){
        log.info("----------Get User By Id API-----------");
        return licenceService.getById(userId);
    }

    //Add User.
    @PostMapping("/add")
    public User add(@RequestBody User user){
        log.info("----------Add User API-----------");
        return licenceService.save(user);
    }

    //Update User
    @PutMapping("/update")
    public User update(@RequestBody User user){
        licenceService.updateUser(user);
        return user;
    }

}
