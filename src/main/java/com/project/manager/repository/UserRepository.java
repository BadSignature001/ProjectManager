package com.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.manager.modal.User;

public interface UserRepository extends JpaRepository<User , Long> {
	
	public User findByEmail(String email) ;

}
