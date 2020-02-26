package mule.extension.internal.connections.configurations;

import java.util.Date;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;

import mule.extension.internal.connections.MuleCustomLoggerConnectionProvider;
import mule.extension.internal.operations.MuleCustomLoggerOperations;

/**
 * This class represents the custom connector element configuration.
 * That means, all values set in this class could be used across custom multiple
 * operations since they represent something core from the custom connector.
 */

/* There we need to define:
 * 
 * Which are the operators that may use the properties of this configuration
 * @Operations(): this annotation will contain all operations the connector provides
 */

@Operations(MuleCustomLoggerOperations.class)		
public class ModuleGeneralConfig {

  /*
   * All properties to be set in the global custom module configuration element
   * 
   * applicationName
   * applicationVersion
   * environment
   *   
   * */	
	
  @Parameter
  private String applicationName;
  @Parameter
  private String applicationVersion;
  @Parameter
  private String environment;
  @Parameter
  private Date globalTimestamp;

  public String getApplicationName(){
	    return applicationName;
  }

  public String getApplicationVersion() {
	return applicationVersion;
  }

  public String getEnvironment() {
	return environment;
  }

public Date getGlobalTimestamp() {
	return globalTimestamp;
}
  
  
  
}
