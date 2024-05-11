package com.project.manager.request;

public class MessageRequest {
	
	
	private Long senderId ;
	private Long projectId ;
	private String content ;
	public Long getSenderId() {
		return senderId;
	}
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MessageRequest(Long senderId, Long projectId, String content) {
		super();
		this.senderId = senderId;
		this.projectId = projectId;
		this.content = content;
	}
	public MessageRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MessageRequest [senderId=" + senderId + ", projectId=" + projectId + ", content=" + content + "]";
	}
	
	
}
