package com.project.manager.service;

import com.project.manager.modal.PlanType;
import com.project.manager.modal.Subscription;
import com.project.manager.modal.User;

public interface SubscriptionService {
	
	Subscription createSubscription(User user) ;
	
	Subscription getUsersSubscription(Long userId)throws Exception ;
	
	Subscription upgradeSubscription(Long userId , PlanType planType) ;
	
	boolean isValid(Subscription subscription) ;

}
