package com.eat.go.user.repo;

import com.eat.go.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Nik Smirnov
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

}
