package com.project.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.manager.modal.Issue;

public interface IssueRepository extends JpaRepository<Issue , Long>{

	public List<Issue> findByProjectID(Long id) ;
}
