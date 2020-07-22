/*
  Created by  : Vivek Kumar
  Created on  : 17/06/2020
  Purpose     : Entity Class.
 */
package com.altran.licencenotification.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String licenceNum;
    private String email;
    private LocalDateTime issueTime;
    private Boolean notified;

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    private LocalDateTime expiryTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLicenceNum() {
        return licenceNum;
    }

    public void setLicenceNum(String licenceNum) {
        this.licenceNum = licenceNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getNotified() {
        return notified;
    }

    public void setNotified(Boolean notified) {
        this.notified = notified;
    }
}
