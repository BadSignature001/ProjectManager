package com.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.manager.modal.Subscription;

public interface SubscriptionRepositroy extends JpaRepository<Subscription ,Long>{
	
	Subscription findByUserId(Long userId) ;
}
