package edu.ksu.canvas.model;

import java.io.Serializable;

public class ColumnDatum extends BaseCanvasModel implements Serializable {

	private static final long serialVersionUID = 6030743515922595897L;

	private String content;
	private String userId;
	
	public ColumnDatum() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
