package edu.ksu.canvas.model;

import java.io.Serializable;

public class CustomColumnDatum extends BaseCanvasModel implements Serializable {

	private static final long serialVersionUID = 287943460056381795L;
	private CustomColumn col;
	private String content;
	private Integer userId;
	
	public CustomColumnDatum(CustomColumn col, String content, Integer user) {
		this.col = col;
		this.content = content;
		this.userId = user;
	}

	public CustomColumn getCol() {
		return col;
	}

	public void setCol(CustomColumn col) {
		this.col = col;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUser() {
		return userId;
	}

	public void setUser(Integer user) {
		this.userId = user;
	}

}
