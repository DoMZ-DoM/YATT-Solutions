package com.yatt.profileservice.profile.model;

public class Image {
	Long id;
	byte[] content;
	String name;
	boolean flag = false;
	public Image(Long id, byte[] content, String name, boolean flag) {
		super();
		this.id = id;
		this.content = content;
		this.name = name;
		this.flag = flag;
	}
	public Image(Long id, byte[] content, String name) {
		super();
		this.id = id;
		this.content = content;
		this.name = name;
	}
	public Image(byte[] content, String name) {
		super();
		this.content = content;
		this.name = name;
	}
	public Image(String name) {
		super();
		this.name = name;
	}
	public Image() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
}
