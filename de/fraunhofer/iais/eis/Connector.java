package de.fraunhofer.iais.eis;

import de.fraunhofer.iais.eis.util.*;
import de.fraunhofer.iais.eis.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.String;
import java.math.BigInteger;
import java.net.URL;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
* "Connector"@en
* "Dedicated communication server for sending and receiving data in compliance with the Connector specification. There are different types of Connectors according to provided capabilities."@en
*/
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Broker.class),
	@JsonSubTypes.Type(value = AppStore.class),
	@JsonSubTypes.Type(value = ParIS.class),
	@JsonSubTypes.Type(value = BaseConnector.class),
	@JsonSubTypes.Type(value = TrustedConnector.class)
})
public interface Connector extends InfrastructureComponent {

	// standard methods

	/**
	* This function retrieves the ID of the current object (can be set via the constructor of the builder class)
	* @return ID of current object as URI
	*/
	@JsonProperty("@id")
	@NotNull
	public URI getId();

	/**
	* This function retrieves a human readable label about the current class, as defined in the ontology.
	* This label could, for example, be used as a field heading in a user interface
	* @return Human readable label
	*/
	public List<TypedLiteral> getLabel();

	/**
	* This function retrieves a human readable explanatory comment about the current class, as defined in the ontology.
	* This comment could, for example, be used as a tooltip in a user interface
	* @return Human readable explanatory comment
	*/
	public List<TypedLiteral> getComment();

	public String toRdf();

	// getter and setter for generic property map
	public Map<String,Object> getProperties();
	public void setProperty(String property, Object value);

	/**
	* This function returns a hash code value for the Connector for the benefit of e.g. hash tables.
	* @return a hash code value for the Connector
	*/
	public int hashCode();

	/**
	* This function indicates whether some other object is equal to this one.
	* @param obj the reference object with which to compare.
	* @return true if this Connector is the same as the obj argument; false otherwise.
	*/
	public boolean equals(Object obj);

	// accessor methods as derived from the IDSA Information Model ontology


	/**
	* "Reference to the Endpoints that serve the resource\'s content or let you exchange messages with an IDS Connector."@en
	* @return Returns the List of ConnectorEndpoints for the property _hasEndpoint.
	* More information under https://w3id.org/idsa/core/hasEndpoint
	*/
	@JsonProperty("ids:hasEndpoint")
	public List<ConnectorEndpoint> getHasEndpoint();

	/**
	* "The Agents for which this Connector may initiate and receive Messages."@en
	* @return Returns the List of URIs for the property _hasAgent.
	* More information under https://w3id.org/idsa/core/hasAgent
	*/
	@JsonProperty("ids:hasAgent")
	public List<URI> getHasAgent();

	/**
	* "References the Catalog of published or requested resource by this Connector."@en
	* @return Returns the List of ResourceCatalogs for the property _resourceCatalog.
	* More information under https://w3id.org/idsa/core/resourceCatalog
	*/
	@JsonProperty("ids:resourceCatalog")
	public List<ResourceCatalog> getResourceCatalog();

	/**
	* "Indicates the default endpoint that should be used for basic infrastructure interactions, e.g., providing the self description."@en
	* @return Returns the ConnectorEndpoint for the property _hasDefaultEndpoint.
	* More information under https://w3id.org/idsa/core/hasDefaultEndpoint
	*/
	@NotNull
	@JsonProperty("ids:hasDefaultEndpoint")
	public ConnectorEndpoint getHasDefaultEndpoint();

	/**
	* "Information of the authentication service used by the Connector."@en
	* @return Returns the AuthInfo for the property _authInfo.
	* More information under https://w3id.org/idsa/core/authInfo
	*/
	@JsonProperty("ids:authInfo")
	public AuthInfo getAuthInfo();

	/**
	* "The SecurityProfile supported by the Connector."@en
	* @return Returns the SecurityProfile for the property _securityProfile.
	* More information under https://w3id.org/idsa/core/securityProfile
	*/
	@NotNull
	@JsonProperty("ids:securityProfile")
	public SecurityProfile getSecurityProfile();

	/**
	* "Reference to a security guarantee that, if used in combination with a security profile instance, overrides the respective guarantee of the given predefined instance."@en
	* @return Returns the List of SecurityGuarantees for the property _extendedGuarantee.
	* More information under https://w3id.org/idsa/core/extendedGuarantee
	*/
	@JsonProperty("ids:extendedGuarantee")
	public List<SecurityGuarantee> getExtendedGuarantee();

}
