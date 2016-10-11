package com.xvshu.zk.manager.model;

import java.util.List;
import java.util.Map;

public class Tree {

	private int id;
	private String text;
	private String state; 
	
	public static final String STATE_OPEN = "open";
	public static final String STATE_CLOSED = "closed";
	private List<Tree> childern;
	private Boolean checked;
	private Map<String, Object> attributes;
	
	public Tree() {
	}
	
	
	public Tree(int id, String text, String state, List<Tree> childern,
			Map<String, Object> attributes) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.childern = childern;
		this.attributes = attributes;
	}


	public Tree(int id, String text, String state, List<Tree> childern) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.childern = childern;
	}


	public Tree(int id, String text, String state, List<Tree> childern,
			boolean checked, Map<String, Object> attributes) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.childern = childern;
		this.checked = checked;
		this.attributes = attributes;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Tree> getChildern() {
		return childern;
	}
	public void setChildern(List<Tree> childern) {
		this.childern = childern;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
}
