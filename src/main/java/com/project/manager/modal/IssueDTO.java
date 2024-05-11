package com.project.manager.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IssueDTO {
	
	private Long id ;
	private String title ;
	private String Description ;
	private String status ;
	private Long projectId ;
	private String priority ;
	private LocalDate dueDate ;
	
	private List<String> tags = new ArrayList<>() ;
	private Project project ;
	
	private User assignee ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public IssueDTO(Long id, String title, String description, String status, Long projectId, String priority,
			LocalDate dueDate, List<String> tags, Project project, User assignee) {
		super();
		this.id = id;
		this.title = title;
		Description = description;
		this.status = status;
		this.projectId = projectId;
		this.priority = priority;
		this.dueDate = dueDate;
		this.tags = tags;
		this.project = project;
		this.assignee = assignee;
	}

	public IssueDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
