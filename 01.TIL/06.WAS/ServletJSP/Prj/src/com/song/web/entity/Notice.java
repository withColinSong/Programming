package com.song.web.entity;

import java.util.Date;

public class Notice {
	
	public Notice() { }
	
	public Notice(int id, String title, Date regdate, String writer_id, String hit, String files, String content) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.writer_id = writer_id;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}
	

	private String title;
	private Date regdate;
	private String writer_id;
	private String hit ;
	private String files;
	private String content;

	private int id;
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
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public String getWriter_id() {
		return writer_id;
	}
	
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	
	public String getHit() {
		return hit;
	}
	
	public void setHit(String hit) {
		this.hit = hit;
	}
	
	public String getFiles() {
		return files;
	}
	
	public void setFiles(String files) {
		this.files = files;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Notice [title=" + title + ", regdate=" + regdate + ", writer_id=" + writer_id + ", hit=" + hit
				+ ", files=" + files + ", content=" + content + ", id=" + id + "]";
	}

}
