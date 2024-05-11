package com.project.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.modal.Chat;
import com.project.manager.repository.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	ChatRepository chatRepository ;
	@Override
	public Chat createChat(Chat chat) {
		
		return chatRepository.save(chat);
	}

}
