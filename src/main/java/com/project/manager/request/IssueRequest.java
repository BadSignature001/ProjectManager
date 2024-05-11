package com.project.manager.request;

import java.time.LocalDate;

public class IssueRequest {
	
	private String title ;
	private String description ;
	private String status ;
	private Long projectId ;
	private String priority ;
	private LocalDate dueDate ;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public IssueRequest(String title, String description, String status, Long projectId, String priority,
			LocalDate dueDate) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.projectId = projectId;
		this.priority = priority;
		this.dueDate = dueDate;
	}
	public IssueRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IssueRequest [title=" + title + ", description=" + description + ", status=" + status + ", projectId="
				+ projectId + ", priority=" + priority + ", dueDate=" + dueDate + "]";
	}
	
	

}
