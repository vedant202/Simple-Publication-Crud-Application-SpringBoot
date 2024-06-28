package com.Publication.Publication.dao;

public class PublicationRequestBody {
	private int id;
	private String title;
	private String type;
	private String content;



	public PublicationRequestBody() {
		super();
	}
	public PublicationRequestBody(int id, String title, String type, String content) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PublicationRequestBody [id=" + id + ", title=" + title + ", type=" + type + ", content=" + content
				+ "]";
	}


}
