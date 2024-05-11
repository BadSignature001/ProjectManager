package com.project.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.manager.modal.Message;

public interface MessageRespository extends JpaRepository<Message , Long>{
	
	 List<Message> findByChatIdOrderByCreatedAtAsc(Long chatId) ;

}
