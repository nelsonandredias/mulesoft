package mule.extension.internal;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

import mule.extension.internal.connections.MuleCustomLoggerConnectionProvider;
import mule.extension.internal.connections.configurations.ModuleGeneralConfig;
import mule.extension.internal.operations.MuleCustomLoggerOperations;


/**
 * This is the main class of a custom connector, which means that it's the entry point of the custom connector
 * and where all configurations, connection providers, operations, and sources are going to be declared.
 */

/*
 * @Xml(prefix = "custom-connector-name-x"): set the prefix of every mule operation/activity
 *  belonging to this custom connector
 * 
 * Considering the custom operation 'activity 1', in the Mule Configuration XML file 
 * the activity will shown as:
 * <custom-connector-name-x:activity1 doc:name="Activity 1" doc:id="075bb422-a027-4937-9ee0-b9a12e911b3f" />
 * 
 * @Extension(name="") : In Mule 4, the connector is called as an extension, so this annotation
 * defines the name of the module connector
 * 
 * @Configurations(): Sometimes, a connector needs to have a global configuration. Thus, this annotation will
 * contain all possible configuration classes
 * */

@Xml(prefix = "custom-logger-module")
@Extension(name = "CustomLoggingModule")
@Configurations(ModuleGeneralConfig.class)
public class MuleCustomLoggerExtension {

}
