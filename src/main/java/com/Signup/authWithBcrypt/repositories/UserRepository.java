package com.Signup.authWithBcrypt.repositories;

import com.Signup.authWithBcrypt.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<SiteUser,Long> {
   SiteUser findByUsername (String username);

}
