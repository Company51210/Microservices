/*
  Created by  : Vivek Kumar
  Created on  : 18/06/2020
  Purpose     : License Service Class.
 */
package com.altran.licencenotification.service;

import com.altran.licencenotification.model.User;
import com.altran.licencenotification.model.UserRepository;
import com.altran.licencenotification.utility.JavaMailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class LicenceService {

    //Logger
    public static final Logger log = LoggerFactory.getLogger(LicenceService.class);

    @Autowired
    UserRepository userRepository;
    Boolean check = false;


    //Get All registered User
    public List<User> get(){
        log.info(">>>>>>Service class Get Method>>>>>");
        return userRepository.findAll();
    }

    //Get All registered User By Id.
    public User getById(Long userId){
        log.info(">>>>>>Service class GetById Method>>>>>");
        return userRepository.getOne(userId);
    }

    //Add User.
    public User save(User user){
        log.info(">>>>>>Service class Save Method>>>>>");
        Timestamp t1 = Timestamp.from(Instant.now());
        user.setIssueTime(t1.toLocalDateTime());
        //Add required Duration for expiry time.(Currently Added 2 Min)
        user.setExpiryTime(t1.toLocalDateTime().plusMinutes(2));
        userRepository.save(user);
        if(!check)
            init();
        return user;
    }


    //This method sends license expiry mail to all users.
    public void sendNotify(){
        List<User> list = userRepository.findAll();
        list.forEach(user -> {
            Timestamp t = Timestamp.from(Instant.now());
            if (t.toLocalDateTime().isAfter(user.getExpiryTime())) {
                try {
                    System.out.println(user);
                    if(!user.getNotified()) {
                        JavaMailUtil.sendMail(user.getEmail());
                        user.setNotified(true);
                        userRepository.save(user);
                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //Method to start another thread for sending notification.
    public void init(){
        check = true;
        //Starting a separate thread.
        new Thread(() -> {
            while (true) {
                sendNotify();
            }
        }).start();
    }

    public User updateUser(User user) {
        User modifiedUser = userRepository.getOne(user.getId());
        Timestamp currentTime = Timestamp.from(Instant.now());
        modifiedUser.setIssueTime(currentTime.toLocalDateTime());
        //Add required Duration for expiry time.(Currently Added 2 Min)
        modifiedUser.setExpiryTime(currentTime.toLocalDateTime().plusMinutes(10));
        userRepository.save(modifiedUser);
        return modifiedUser;
    }
}
