package com.project.manager.service;

import java.util.List;
import java.util.Optional;

import com.project.manager.modal.Issue;
import com.project.manager.modal.User;
import com.project.manager.request.IssueRequest;

public interface IssueService {
	
	Issue getIssueById(Long issueId)throws Exception ;
	
	List<Issue> getIssueByProjectId(Long projectId)throws Exception; 
	
	Issue createIssue(IssueRequest issue, User user)throws Exception ;

	void deleteIssue(Long issueId, Long userid)throws Exception ;
	
	
	Issue addUserToIssue(Long issueId, Long userId)throws Exception ;
	
	Issue updateStatus(Long issueId,  String status)throws Exception ;

}
