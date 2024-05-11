package com.project.manager.service;

import java.util.List;

import com.project.manager.modal.Message;

public interface MessageService {
	
	Message sendMessage(Long senderId , Long chatId , String content)throws Exception ;
	List<Message> getMessageByProjectId(long projectId) throws Exception;


}
