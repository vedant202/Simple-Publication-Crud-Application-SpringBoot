package com.Publication.Publication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PublicationEntity {
	@Id
	private int id;
	private String title;
	private String type;
	private String content;




	public PublicationEntity() {
		super();
	}
	public PublicationEntity(int id, String title, String type, String content) {
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
		return "PublicationEntity [id=" + id + ", title=" + title + ", type=" + type + ", content=" + content + "]";
	}


}
