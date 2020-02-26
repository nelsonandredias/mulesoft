package mule.extension.internal.models;

import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;


/**
 * This class is used to create the parameter that will represent 
 * a dropdown box in the custom connector Logger operation.
 * 
 * For that, it was set an enum class with all the possible logging output options.
 */

public class OutputFormat {
	
	/**
	 * Available printing log outputs to be shown in the dropdown box
	 */
	public enum PrintingOutputs{
	        XML,
	        JSON
	};
	  
	/**
	 * Create a required parameter that represents the dropdown box with priority log
	 * 
	 */
	@Parameter
	@DisplayName("LoggingPrint")
	@Summary("The printing log output to be used. The default is JSON. Available printing log outputs are : XML, JSON")
	@Expression(org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED)
	private PrintingOutputs printingOutputs;

	public PrintingOutputs getPrintingOutputs() {
		return printingOutputs;
	}

	public void setPrintingOutputs(PrintingOutputs printingOutputs) {
		this.printingOutputs = printingOutputs;
	}

	
}
