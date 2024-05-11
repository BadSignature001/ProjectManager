package com.project.manager.request;

public class CreateCommentRequest {
	
	private Long issueId ;
	private String content ;
	public Long getIssueId() {
		return issueId;
	}
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CreateCommentRequest(Long issueId, String content) {
		super();
		this.issueId = issueId;
		this.content = content;
	}
	public CreateCommentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
