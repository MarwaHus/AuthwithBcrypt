package com.Signup.authWithBcrypt.repositories;

import com.Signup.authWithBcrypt.models.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostUser,String> {
    PostUser findByUsername(String username);
}
