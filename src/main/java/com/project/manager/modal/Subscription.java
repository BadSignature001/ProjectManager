package com.project.manager.modal;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Subscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	private LocalDate subscriptionStartDate ;
	private LocalDate getSubscriptionEndDate ;
	private PlanType planType ;
	
	private boolean isValid ;
	
	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	public LocalDate getGetSubscriptionEndDate() {
		return getSubscriptionEndDate;
	}

	public void setGetSubscriptionEndDate(LocalDate getSubscriptionEndDate) {
		this.getSubscriptionEndDate = getSubscriptionEndDate;
	}

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subscription(Long id, LocalDate subscriptionStartDate, LocalDate getSubscriptionEndDate, PlanType planType,
			boolean isValid, User user) {
		super();
		this.id = id;
		this.subscriptionStartDate = subscriptionStartDate;
		this.getSubscriptionEndDate = getSubscriptionEndDate;
		this.planType = planType;
		this.isValid = isValid;
		this.user = user;
	}

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	

}
