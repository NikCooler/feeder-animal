package com.eat.go.user.repo;

import com.eat.go.user.domain.User;
import com.eat.go.user.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mysm on 10/16/2016.
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
}
