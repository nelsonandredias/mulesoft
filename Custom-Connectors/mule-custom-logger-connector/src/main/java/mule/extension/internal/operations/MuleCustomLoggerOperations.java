package mule.extension.internal.operations;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.JSONObject;
import org.json.XML;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.dsl.xml.ParameterDsl;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import mule.extension.internal.connections.configurations.ModuleGeneralConfig;
import mule.extension.internal.models.Application;
import mule.extension.internal.models.Audit;
import mule.extension.internal.models.LogLevel;
import mule.extension.internal.models.LoggingInformation;
import mule.extension.internal.models.OutputFormat;
import mule.extension.internal.models.OutputLog;
import mule.extension.internal.models.Traceability;
import mule.extension.internal.models.TrackingPoint;

import org.mule.runtime.extension.api.annotation.param.Config;


/**
 * This class is a container for operations, 
 * every public method in this class will be taken as a custom connector operation.
 */

/*
 * A custom connector operation represents a mulesoft module activity.
 * */


public class MuleCustomLoggerOperations {

	private final Logger LOGGER = LoggerFactory.getLogger(MuleCustomLoggerOperations.class);
	
  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
  @MediaType(value = ANY, strict = false)
  @DisplayName("Custom Logger")
  public void customerLogger(
		  @Config ModuleGeneralConfig configuration,
		  @ParameterDsl(allowInlineDefinition= true, allowReferences=false) @Expression(org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED) LoggingInformation loggingInformation,
		  @ParameterDsl(allowInlineDefinition= true, allowReferences=false) @Expression(org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED) OutputFormat outputFormat,
		  @ParameterDsl(allowInlineDefinition= true, allowReferences=false) @Expression(org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED) LogLevel logLevel,
		  @ParameterDsl(allowInlineDefinition= true, allowReferences=false) @Expression(org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED) TrackingPoint trackingPoint){
   
	  //Creating object "Application"
	  Application application = new Application();
	  application.setApplicationName(configuration.getApplicationName());
	  application.setApplicationVersion(configuration.getApplicationVersion());
	  application.setEnvironment(configuration.getEnvironment());
	  
	  //Creating object "Traceability"
	  Traceability traceability = new Traceability();
	  traceability.setLevelLogs(logLevel.getLevelLog());
	  traceability.setTrackingPoint(trackingPoint.getTrackingPoint());
	  
	  //Creating object "Audit"
	  Audit audit = new Audit();
	  audit.setTrackingPoint(trackingPoint.getTrackingPoint());
	  audit.setFlowName(loggingInformation.getFlowName());
	  audit.setMessage(loggingInformation.getMessage());
	  audit.setLevelLogs(logLevel.getLevelLog());
	  audit.setContent(loggingInformation.getContent());
	  
	  // Creating object "OutputLog"
	  OutputLog outputLog = new OutputLog(formatDateTime(configuration.getGlobalTimestamp()),
			  					loggingInformation.getCorrelationID(), 
			  					application, 
			  					audit);
	
	 /**
	  * Verify the outputFormat selected by the user
	  */
	  if (outputFormat.getPrintingOutputs().toString().equals("JSON")) {
		  formatJSONLog(logLevel.getLevelLog().toString() , outputLog);	
	  } else {
		formatXMLLog(logLevel.getLevelLog().toString(), outputLog);		
	  }
	  
  }

  /*********************************************************************
   * Private Methods are not exposed as operations
   ********************************************************************/
  
  /**
   * Method to format date time
   * 
   * Input parameters
   * @param timestamp - raw date 
   * @return String - formatted date
   */
  private String formatDateTime(Date timestamp) {
	  
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
	  return dateFormat.format(timestamp);
  }  
  
  /**
   * Method to print out log in JSON format
   * 
   * @param logLevel - log level selected by the user
   * @param outputLog - object with log data for printing
   */
  private void formatJSONLog(String logLevel, OutputLog outputLog) {
	  
	  //create json log string
	  String JSONLog = createStringJSON(outputLog);
	  
	  // Print out JSON String
	  setLogLevel(logLevel, JSONLog);
	 
	  
  }
  
  /**
   * Method to print out log in XML format
   * 
   * @param logLevel - log level selected by the user
   * @param outputLog - object with log data for printing
   */
  private void formatXMLLog(String logLevel, OutputLog outputLog) {
	  
	  //create json log string
	  String JSONLog = createStringJSON(outputLog);
	  
	  //create JSON object to convert into XML
	  JSONObject jsonObject = new JSONObject(JSONLog);
	  
	  //get raw xml string
	  String XMLRaw = XML.toString(jsonObject);
	  
	  //pretty print xml string
	  String XMLPrettyPrint = getPrettyPrintXMLString(XMLRaw);
	  
	  //Print out pretty print XML String
	  setLogLevel(logLevel, XMLPrettyPrint);
	  
  }
  
  /**
   * Method to create JSON string based on object
   * 
   * @param outputLog - object with log data to be printed out
   * @return - jSON string with log data
   */
  private String createStringJSON(OutputLog outputLog) {
	
	  ObjectMapper outputLogJSON = new ObjectMapper();	
	  String jsonStr = "";
	  
	  try { 
			  
		  // get pretty print JSON string 
	      jsonStr = outputLogJSON.writerWithDefaultPrettyPrinter().writeValueAsString(outputLog); 	         
	  } 
	  catch (IOException e) { 
		  e.printStackTrace(); 
	  }
	  
	  return jsonStr;
  }
  
  /**
   * Method to pretty print a raw XML string
   * 
   * @param xmlString - raw XML string
   * @return - pretty print XML string
   */
  private String getPrettyPrintXMLString(String xmlString) {
	  
	  TransformerFactory transformerFactory = TransformerFactory.newInstance();
	  transformerFactory.setAttribute("indent-number", 2);
	  
	  String prettyPrintXML = null;
	  
	  try {
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		
		StringWriter stringWriter = new StringWriter();
		
		StreamResult xmlOutput = new StreamResult(stringWriter);
		
		Source xmlInput = new StreamSource(new StringReader("<root>"+ xmlString+"</root>"));
		
		try {
			transformer.transform(xmlInput, xmlOutput);
			
			prettyPrintXML = xmlOutput.getWriter().toString();
			
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} catch (TransformerConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return prettyPrintXML;
	  
  }
  
  /**
   * Method to print out the log message according to the log level
   * 
   * Input parameters:
   * @param logLevel - log level selected by the user
   * @param outputMessage - string message to be printed in the log
   */
  private void setLogLevel(String logLevel, String outputMessage) {
	  
	  if(logLevel.equals("ERROR")) {
		  LOGGER.error(outputMessage);
	  }
	  else if (logLevel.equals("WARN")) {
		  LOGGER.warn(outputMessage);
	  }
	  else if (logLevel.equals("DEBUG")) {
		  LOGGER.warn(outputMessage);
	  }
	  else if (logLevel.equals("TRACE")) {
		  LOGGER.warn(outputMessage);
	  }
	  else {
		  LOGGER.info(outputMessage);
	  }	  
	  
  }  
  
}
