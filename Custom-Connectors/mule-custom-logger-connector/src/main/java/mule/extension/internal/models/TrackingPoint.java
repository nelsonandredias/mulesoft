package mule.extension.internal.models;

import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.dsl.xml.ParameterDsl;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

/**
 * This class is used to create the parameter that will represent 
 * a dropdown box in the custom connector Logger operation.
 * 
 * For that, it was set an enum class with all the possible tracing point options.
 */

public class TrackingPoint {

	/**
	 * Available tracking points to be shown in the dropdown box
	 */
	public enum TracePoints{
	        START, 
	        END, 
	        BEFORE_API_OR_BACKEND_REQUEST, 
	        AFTER_API_OR_BACKEND_REQUEST,
	        BEFORE_PAYLOAD_TRANSFORM,
	        AFTER_PAYLOAD_TRANSFORM
	};
	  
	/**
	 * Create a required parameter that represents the dropdown box with tracking points options
	 * 
	 */
	@Parameter
	@DisplayName("Tracking Point")
	@Summary("Select the current flow point for tracing. Available tracking points are : START, END, BEFORE_API_OR_BACKEND_REQUEST, AFTER_API_OR_BACKEND_REQUEST, BEFORE_PAYLOAD_TRANSFORM, AFTER_PAYLOAD_TRANSFORM")
	private TracePoints trackingPoint;

	public TracePoints getTrackingPoint() {
		return trackingPoint;
	}

	public void setTrackingPoint(TracePoints trackingPoint) {
		this.trackingPoint = trackingPoint;
	}

	

	 
	
}
