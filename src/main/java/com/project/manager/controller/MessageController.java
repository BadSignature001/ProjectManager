package com.project.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.manager.modal.Chat;
import com.project.manager.modal.Message;
import com.project.manager.modal.User;
import com.project.manager.request.MessageRequest;
import com.project.manager.service.MessageService;
import com.project.manager.service.ProjectService;
import com.project.manager.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private MessageService messageService ;
	
	@Autowired
	private ProjectService projectService ;
	
	@PostMapping("/send")
	public ResponseEntity<Message> sendMessage(@RequestBody MessageRequest request)throws Exception
	{
		User user = userService.findUserById(request.getSenderId()) ;
		if(user == null ) throw new Exception("user not found with id" +request.getSenderId()) ;
		Chat chats = projectService.getProjectById(request.getProjectId()).getChat();	
		if(chats == null)throw new Exception("Chats not found") ;
		
		Message sentMessage = messageService.sendMessage(request.getSenderId(),request.getProjectId(), request.getContent());
		return ResponseEntity.ok(sentMessage) ;
	} 
	@GetMapping("/chat/{projectId}")
	public ResponseEntity<List<Message>> getMessagesByChatId(@PathVariable long projetId)throws Exception{
		List<Message> messages = messageService.getMessageByProjectId(projetId);
		return ResponseEntity.ok(messages) ;
	}
	
	
}
