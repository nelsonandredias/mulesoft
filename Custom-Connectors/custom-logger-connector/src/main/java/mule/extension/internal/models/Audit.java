package mule.extension.internal.models;

import java.util.Date;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import mule.extension.internal.models.LogLevel.PriorityLevels;
import mule.extension.internal.models.TrackingPoint.TracePoints;

public class Audit {
	
	private TracePoints trackingPoint;
	private String flowName;
	private String message;
	private PriorityLevels levelLogs;
	private String content;
	
	public TracePoints getTrackingPoint() {
		return trackingPoint;
	}
	public void setTrackingPoint(TracePoints trackingPoint) {
		this.trackingPoint = trackingPoint;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PriorityLevels getLevelLogs() {
		return levelLogs;
	}
	public void setLevelLogs(PriorityLevels levelLogs) {
		this.levelLogs = levelLogs;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
