package edu.ksu.canvas.model;

import java.io.Serializable;
import java.util.List;

public class GradingStandard extends BaseCanvasModel implements Serializable {
	
	private long id;
	private String title;
	private String contextType;
	private Integer contextId;
	private List<GradingSchemeEntry> gradingScheme;
	
	private static final long serialVersionUID = -6322272760975095220L;

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

	public String getContextType() {
		return contextType;
	}

	public void setContextType(String contextType) {
		this.contextType = contextType;
	}

	public Integer getContextId() {
		return contextId;
	}

	public void setContextId(Integer contextId) {
		this.contextId = contextId;
	}

	public List<GradingSchemeEntry> getGradingScheme() {
		return gradingScheme;
	}

	public void setGradingScheme(List<GradingSchemeEntry> gradingScheme) {
		this.gradingScheme = gradingScheme;
	}

}
