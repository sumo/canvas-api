package edu.ksu.canvas.model;

import java.io.Serializable;

public class CustomColumn extends BaseCanvasModel implements Serializable {
	
    private long id;
	private static final long serialVersionUID = -8018653012650187571L;
	private String title;
	private Integer position;
	private boolean hidden;
	
	public CustomColumn(String title) {
		super();
		this.title = title;
	}

	public CustomColumn(String title, boolean hidden) {
		super();
		this.title = title;
		this.hidden = hidden;

	}

	public CustomColumn(String title, Integer position, boolean hidden) {
		super();
		this.title = title;
		this.position = position;
		this.hidden = hidden;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

}
