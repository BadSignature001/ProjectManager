package com.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.manager.modal.Chat;

public interface ChatRepository extends JpaRepository<Chat , Long>{

}
