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

public class IdentityProviderBuilder {

	private IdentityProviderImpl identityProviderImpl;

	public IdentityProviderBuilder() {
		identityProviderImpl = new IdentityProviderImpl();
	}

	public IdentityProviderBuilder(URI id) {
		this();
		identityProviderImpl.id = id;
	}


	/**
	* This function allows setting a value for _maintainer
	* @param _maintainer_ desired value to be set
	* @return Builder object with new value for _maintainer
	*/
	final public IdentityProviderBuilder _maintainer_(URI _maintainer_) {
		this.identityProviderImpl._maintainer = _maintainer_;
		return this;
	}


	/**
	* This function allows setting a value for _curator
	* @param _curator_ desired value to be set
	* @return Builder object with new value for _curator
	*/
	final public IdentityProviderBuilder _curator_(URI _curator_) {
		this.identityProviderImpl._curator = _curator_;
		return this;
	}


	/**
	* This function allows setting a value for _inboundModelVersion
	* @param _inboundModelVersion_ desired value to be set
	* @return Builder object with new value for _inboundModelVersion
	*/
	final public IdentityProviderBuilder _inboundModelVersion_(List<String> _inboundModelVersion_) {
		this.identityProviderImpl._inboundModelVersion = _inboundModelVersion_;
		return this;
	}


	/**
	* This function allows setting a value for _outboundModelVersion
	* @param _outboundModelVersion_ desired value to be set
	* @return Builder object with new value for _outboundModelVersion
	*/
	final public IdentityProviderBuilder _outboundModelVersion_(String _outboundModelVersion_) {
		this.identityProviderImpl._outboundModelVersion = _outboundModelVersion_;
		return this;
	}


	/**
	* This function allows setting a value for _physicalLocation
	* @param _physicalLocation_ desired value to be set
	* @return Builder object with new value for _physicalLocation
	*/
	final public IdentityProviderBuilder _physicalLocation_(Location _physicalLocation_) {
		this.identityProviderImpl._physicalLocation = _physicalLocation_;
		return this;
	}


	/**
	* This function allows setting a value for _componentCertification
	* @param _componentCertification_ desired value to be set
	* @return Builder object with new value for _componentCertification
	*/
	final public IdentityProviderBuilder _componentCertification_(ComponentCertification _componentCertification_) {
		this.identityProviderImpl._componentCertification = _componentCertification_;
		return this;
	}


	/**
	* This function allows setting a value for _publicKey
	* @param _publicKey_ desired value to be set
	* @return Builder object with new value for _publicKey
	*/
	final public IdentityProviderBuilder _publicKey_(PublicKey _publicKey_) {
		this.identityProviderImpl._publicKey = _publicKey_;
		return this;
	}


	/**
	* This function allows setting a value for _version
	* @param _version_ desired value to be set
	* @return Builder object with new value for _version
	*/
	final public IdentityProviderBuilder _version_(String _version_) {
		this.identityProviderImpl._version = _version_;
		return this;
	}


	/**
	* This function allows setting a value for _title
	* @param _title_ desired value to be set
	* @return Builder object with new value for _title
	*/
	final public IdentityProviderBuilder _title_(List<TypedLiteral> _title_) {
		this.identityProviderImpl._title = _title_;
		return this;
	}


	/**
	* This function allows setting a value for _description
	* @param _description_ desired value to be set
	* @return Builder object with new value for _description
	*/
	final public IdentityProviderBuilder _description_(List<TypedLiteral> _description_) {
		this.identityProviderImpl._description = _description_;
		return this;
	}
	/**
	* This function takes the values that were set previously via the other functions of this class and turns them into a Java bean.
	* @return Bean with specified values
	* @throws ConstraintViolationException This exception is thrown, if a validator is used and a violation is found.
	*/

	final public IdentityProvider build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(identityProviderImpl);
		return identityProviderImpl;
	}
}
