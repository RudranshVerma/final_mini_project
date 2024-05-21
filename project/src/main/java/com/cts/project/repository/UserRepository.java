package com.cts.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailId(String email);
    void deleteByEmailId(String email);
	Optional<User> findOneByEmailIdAndPassword(String email, String encodedPassword);
	

	
}
