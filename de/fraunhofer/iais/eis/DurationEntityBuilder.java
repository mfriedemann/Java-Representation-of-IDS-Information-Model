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

public class DurationEntityBuilder {

	private DurationEntityImpl durationEntityImpl;

	public DurationEntityBuilder() {
		durationEntityImpl = new DurationEntityImpl();
	}

	public DurationEntityBuilder(URI id) {
		this();
		durationEntityImpl.id = id;
	}


	/**
	* This function allows setting a value for _hasDuration
	* @param _hasDuration_ desired value to be set
	* @return Builder object with new value for _hasDuration
	*/
	final public DurationEntityBuilder _hasDuration_(javax.xml.datatype.Duration _hasDuration_) {
		this.durationEntityImpl._hasDuration = _hasDuration_;
		return this;
	}

	/**
	* This function takes the values that were set previously via the other functions of this class and turns them into a Java bean.
	* @return Bean with specified values
	* @throws ConstraintViolationException This exception is thrown, if a validator is used and a violation is found.
	*/

	final public DurationEntity build() throws ConstraintViolationException {
		VocabUtil.getInstance().validate(durationEntityImpl);
		return durationEntityImpl;
	}
}
