package mule.extension.internal.connections;

import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

/**
 * This class is used by connection providers to handle the connection.
 * By having the single connection class and multiple connection providers,
 * we can create multiple connection configurations for our Connector.
 * 
 * represents a custom element connection just as example (there is no real connection with anything here c:).
 */
public final class CustomLoggerConnection {


  private static final String GENL = "General";
  
  public enum Channel {
	     START, END 
	  };
	
  private final String id;

  public CustomLoggerConnection(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
  
  
 
  
  @Parameter
  @Placement(tab = GENL)
  @DisplayName("Trace Point")
  @Summary("Options: START, END ")
  @Expression(org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED)
  private String tracePoint;
  
  public String getTracePoint() {
        return tracePoint;
  }
  
  public void invalidate() {
    // do something to invalidate this connection!
  }
}
