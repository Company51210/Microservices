/*
  Created by  : Vivek Kumar
  Created on  : 17/06/2020
  Purpose     : Repository Interface.
 */
package com.altran.licencenotification.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
