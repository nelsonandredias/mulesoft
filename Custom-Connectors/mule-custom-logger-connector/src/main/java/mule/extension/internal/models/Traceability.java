package mule.extension.internal.models;

import mule.extension.internal.models.LogLevel.PriorityLevels;
import mule.extension.internal.models.TrackingPoint.TracePoints;

public class Traceability {
	
	private TracePoints trackingPoint;
	private PriorityLevels levelLogs;
	
	public Traceability() {
	}
	
	public Traceability(TracePoints trackingPoint, PriorityLevels levelLogs) {
		super();
		this.trackingPoint = trackingPoint;
		this.levelLogs = levelLogs;
	}

	public TracePoints getTrackingPoint() {
		return trackingPoint;
	}

	public void setTrackingPoint(TracePoints trackingPoint) {
		this.trackingPoint = trackingPoint;
	}

	public PriorityLevels getLevelLogs() {
		return levelLogs;
	}

	public void setLevelLogs(PriorityLevels levelLogs) {
		this.levelLogs = levelLogs;
	}

	

}
