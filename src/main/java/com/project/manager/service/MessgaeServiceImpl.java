package com.project.manager.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.modal.Chat;
import com.project.manager.modal.Message;
import com.project.manager.modal.User;
import com.project.manager.repository.MessageRespository;
import com.project.manager.repository.UserRepository;

@Service
public class MessgaeServiceImpl implements MessageService{
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private ProjectService projectService ;
	
	@Autowired
	private MessageRespository messageRepository ;

	@Override
	public Message sendMessage(Long senderId, Long projectId, String content) throws Exception {
		
		User sender = userRepository.findById(senderId).orElseThrow(()->new Exception("User not found with id"+senderId));
		Chat chat = projectService.getProjectById(projectId).getChat() ;
		
		Message message = new Message() ;
		
		message.setContent(content);
		message.setSender(sender);
		message.setCreatedAt(LocalDateTime.now());
		message.setChat(chat);
		Message savedMessage = messageRepository.save(message) ;
		chat.getMessages().add(savedMessage) ;
		
		
		return savedMessage;
	}

	@Override
	public List<Message> getMessageByProjectId(long projectId) throws Exception {
		Chat chat = projectService.getChatByProjectId(projectId) ;
		List<Message> findByChatIdOrderByCreatedAtAsc=  messageRepository.findByChatIdOrderByCreatedAtAsc(chat.getId()) ;
		return findByChatIdOrderByCreatedAtAsc;
	}

}
