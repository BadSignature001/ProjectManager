package com.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.manager.modal.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation , Long>{
	Invitation findByToken(String token) ;
	
	Invitation findByEmail(String userEmail) ;
}
