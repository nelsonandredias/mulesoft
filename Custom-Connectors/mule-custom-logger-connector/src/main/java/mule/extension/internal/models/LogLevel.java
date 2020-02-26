package mule.extension.internal.models;

import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.dsl.xml.ParameterDsl;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

/**
 * This class is used to create the parameter that will represent 
 * a dropdown box in the custom connector Logger operation.
 * 
 * For that, it was set an enum class with all the possible log level options.
 */

public class LogLevel {

	/**
	 * Available log levels to be shown in the dropdown box
	 */
	public enum PriorityLevels{
	        DEBUG,
	        ERROR,
	        INFO,
	        TRACE,
	        WARN
	};
	  
	/**
	 * Create a required parameter that represents the dropdown box with log level
	 * 
	 */
	@Parameter
	@DisplayName("Log Level")
	@Summary("The logging level priority to be used. The default is INFO. Available log priorities are : TRACE, DEBUG, INFO, WARN, ERROR")
	private PriorityLevels levelLog;

	public PriorityLevels getLevelLog() {
		return levelLog;
	}

	

}
	
