package com.example.demo.user.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> getAllByFirstName(String firstName);

	User getById(Long id);

	User findByEmail(String email);

	User findByFirstName(String firstName);

	User findByUserName(String userName);
}
