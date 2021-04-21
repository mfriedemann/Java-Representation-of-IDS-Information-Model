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

public class ResourceCatalogBuilder {

	private ResourceCatalogImpl resourceCatalogImpl;

	public ResourceCatalogBuilder() {
		resourceCatalogImpl = new ResourceCatalogImpl();
	}

	public ResourceCatalogBuilder(URI id) {
		this();
		resourceCatalogImpl.id = id;
	}

	/**
	* This function allows setting a value for _requestedResource
	* @param _requestedResource_ desired value to be set
	* @return Builder object with new value for _requestedResource
	*/
	final public ResourceCatalogBuilder _requestedResource_(List<Resource> _requestedResource_) {
		this.resourceCatalogImpl._requestedResource = _requestedResource_;
		return this;
	}


	/**
	* This function allows setting a value for _offeredResource
	* @param _offeredResource_ desired value to be set
	* @return Builder object with new value for _offeredResource
	*/
	final public ResourceCatalogBuilder _offeredResource_(List<Resource> _offeredResource_) {
		this.resourceCatalogImpl._offeredResource = _offeredResource_;
		return this;
	}


	/**
	* This function takes the values that were set previously via the other functions of this class and turns them into a Java bean.
	* @return Bean with specified values
	* @throws ConstraintViolationException This exception is thrown, if a validator is used and a violation is found.
	*/

	final public ResourceCatalog build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(resourceCatalogImpl);
		return resourceCatalogImpl;
	}
}
