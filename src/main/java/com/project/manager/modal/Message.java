package com.project.manager.modal;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	
	private String content ;
	
	private LocalDateTime createdAt ;
	
	@ManyToOne
	private Chat chat ;
	
	@ManyToOne
	private User sender ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Message(Long id, String content, LocalDateTime createdAt, Chat chat, User sender) {
		super();
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.chat = chat;
		this.sender = sender;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
