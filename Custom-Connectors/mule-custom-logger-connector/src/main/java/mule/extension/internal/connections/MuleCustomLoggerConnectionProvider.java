package mule.extension.internal.connections;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mule.extension.internal.connections.configurations.ModuleGeneralConfig;



/**
 * This class (as it's name implies) provides connection instances and the funcionality to disconnect
 * and validate those connections.
 * 
 * All connection related parameters (values required in order to create a connection) must be
 * declared in the connection providers.
 * 
 * This particular example is a {@link PoolingConnectionProvider} which declares that connections resolved by this provider
 * will be pooled and reused. There are other implementations like {@link CachedConnectionProvider} which lazily creates and
 * caches connections or simply {@link ConnectionProvider} if you want a new connection each time something requires one.
 */
public class MuleCustomLoggerConnectionProvider {
//public class MuleCustomLoggerConnectionProvider implements PoolingConnectionProvider<CustomLoggerConnection> {
  private final Logger LOGGER = LoggerFactory.getLogger(MuleCustomLoggerConnectionProvider.class);

  
  /**
   * A parameter that is always required to be configured.
   
  @Parameter
  private String requiredParameter;
*/
  /**
   * Application configuration group properties:
   * 
   * Group added to the tab "general" of the global custom module configuration element
   
  @ParameterGroup(name = "Application")
  ApplicationGeneralConfig applicationConfig;
 */
  
 
  //A parameter that is not required to be configured by the user.
  
//  @DisplayName("Friendly Parameter Name")
//  @Parameter
//  @Optional(defaultValue = "100000")
//  private int optionalParameter;
//  
//  @Parameter
//  @Placement(tab = "Advanced")
//  @Optional(defaultValue = "5000")
//  int connectionTimeout;

  
//  @Override
//  public CustomLoggerConnection connect() throws ConnectionException {
//    return new CustomLoggerConnection("requiredParameter" + ":" + "optionalParameter");
//  }
//
//  @Override
//  public void disconnect(CustomLoggerConnection connection) {
//    try {
//      connection.invalidate();
//    } catch (Exception e) {
//      LOGGER.error("Error while disconnecting [" + connection.getId() + "]: " + e.getMessage(), e);
//    }
//  }
//
//  @Override
//  public ConnectionValidationResult validate(CustomLoggerConnection connection) {
//    return ConnectionValidationResult.success();
//  }
}
