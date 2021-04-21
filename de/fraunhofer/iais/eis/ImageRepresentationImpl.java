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
* "Image Representation"@en
* "Image representation"@en 
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:ImageRepresentation")
public class ImageRepresentationImpl implements Serializable, ImageRepresentation {

	@JsonProperty("@id")
	@JsonAlias({"@id", "id"})
	@NotNull
	protected URI id;

	//List of all labels of this class
	@JsonIgnore
	protected List<TypedLiteral> label = Arrays.asList(new TypedLiteral("Image Representation", "en"));

	//List of all comments of this class
	@JsonIgnore
	protected List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Image representation", "en"));

	// all classes have a generic property array
	@JsonIgnore
	protected Map<String,Object> properties;

	// instance fields as derived from the IDSA Information Model ontology

	/**
	* "created"@en
	* "The date of the creation of the Digital Content. In contrast to the ids:temporalCoverage, creation dates of ids:Representation, ids:Artifacts or any other form of meta-data, this property describes the creation date of referenced Digital Content itself."@en
	*/
	@JsonAlias({"ids:created", "created"})
	protected XMLGregorianCalendar _created;


	/**
	* "height"@en
	* "Height of the visible frame."@en
	*/
	@JsonAlias({"ids:height", "height"})
	protected java.math.BigDecimal _height;


	/**
	* "instance"@en
	* "Reference to an instance of given representation, i.e. inline value or file placeholder."@en
	*/
	@JsonAlias({"ids:instance", "instance"})
	protected List<RepresentationInstance> _instance;


	/**
	* "language"@en
	* "Natural language(s) used within the content."@en
	*/
	@JsonAlias({"ids:language", "language"})
	protected Language _language;


	/**
	* "media type"@en
	* "Media Type of the Representation."@en
	*/
	@JsonAlias({"ids:mediaType", "mediaType"})
	protected MediaType _mediaType;


	/**
	* "modified"@en
	* "The date/time this Digital Content has been changed the last time. Only one \'modified\' attribute is usually needed."@en
	*/
	@JsonAlias({"ids:modified", "modified"})
	protected XMLGregorianCalendar _modified;


	/**
	* "representation standard"@en
	* "Standards document defining the given Representation (in contrast to general Resource content). The Representation is assumed to conform to that Standard."@en
	*/
	@JsonAlias({"ids:representationStandard", "representationStandard"})
	protected URI _representationStandard;


	/**
	* "shapeGraph"@en
	* "Reference to SHACL shape graph, which describes domain-specific knowledge."@en
	*/
	@JsonAlias({"ids:shapesGraph", "shapesGraph"})
	protected URI _shapesGraph;


	/**
	* "width"@en
	* "Width of the visible frame."@en
	*/
	@JsonAlias({"ids:width", "width"})
	protected java.math.BigDecimal _width;


	// no manual construction
	protected ImageRepresentationImpl() {
		id = VocabUtil.getInstance().createRandomUrl("imageRepresentation");
	}

	@JsonProperty("@id")
	final public URI getId() {
		return id;
	}

	public String toRdf() {
		return VocabUtil.getInstance().toRdf(this);
	}

	public List<TypedLiteral> getLabel() {
		return this.label;
	}

	public List<TypedLiteral> getComment() {
		return this.comment;
	}

	// getter and setter for generic property map
	@JsonAnyGetter
	public Map<String,Object> getProperties() {
		if (this.properties == null) return null;
		Iterator<String> iter = this.properties.keySet().iterator();
		Map<String,Object> resultset = new HashMap<String, Object>();
		while (iter.hasNext()) {
			String key = iter.next();
			resultset.put(key,urifyObjects(this.properties.get(key)));
		}
		return resultset ;
	}

	public Object urifyObjects(Object value) {
		if (value instanceof String && value.toString().startsWith("http")) {
			try {
				value = new URI(value.toString());
			} catch (Exception e) { /* do nothing */ }
		} else if (value instanceof ArrayList) {
			ArrayList<Object> result_array = new ArrayList<Object>();
			((ArrayList) value).forEach(x -> result_array.add(urifyObjects(x)));
			return result_array;
		} else if (value instanceof Map) {
			Map<String, Object> result_map = new HashMap<String, Object>();
			((Map) value).forEach((k,v) -> result_map.put(k.toString(), urifyObjects(v)));
			return result_map;
		}
		return value;
	}

	@JsonAnySetter
	public void setProperty(String property, Object value) {
		if (this.properties == null) this.properties = new HashMap<String,Object>();
		if (property.startsWith("@")) {return ;};
		this.properties.put(property, value) ;
	}
	public int hashCode() {
		return Objects.hash(new Object[]{this._width,
			this._height,
			this._instance,
			this._mediaType,
			this._representationStandard,
			this._language,
			this._created,
			this._modified,
			this._shapesGraph});
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			ImageRepresentationImpl other = (ImageRepresentationImpl) obj;
			return Objects.equals(this._width, other._width) &&
				Objects.equals(this._height, other._height) &&
				Objects.equals(this._instance, other._instance) &&
				Objects.equals(this._mediaType, other._mediaType) &&
				Objects.equals(this._representationStandard, other._representationStandard) &&
				Objects.equals(this._language, other._language) &&
				Objects.equals(this._created, other._created) &&
				Objects.equals(this._modified, other._modified) &&
				Objects.equals(this._shapesGraph, other._shapesGraph);
		}
	}


	// accessor method implementations as derived from the IDSA Information Model ontology


	@JsonProperty("ids:width")
	final public java.math.BigDecimal getWidth() {
		return _width;
	}
	
	final public void setWidth (java.math.BigDecimal _width_) {
		this._width = _width_;
	}

	@JsonProperty("ids:height")
	final public java.math.BigDecimal getHeight() {
		return _height;
	}
	
	final public void setHeight (java.math.BigDecimal _height_) {
		this._height = _height_;
	}

	@JsonProperty("ids:instance")
	final public List<RepresentationInstance> getInstance() {
		return _instance;
	}
	
	final public void setInstance (List<RepresentationInstance> _instance_) {
		this._instance = _instance_;
	}

	@JsonProperty("ids:mediaType")
	final public MediaType getMediaType() {
		return _mediaType;
	}
	
	final public void setMediaType (MediaType _mediaType_) {
		this._mediaType = _mediaType_;
	}

	@JsonProperty("ids:representationStandard")
	final public URI getRepresentationStandard() {
		return _representationStandard;
	}
	
	final public void setRepresentationStandard (URI _representationStandard_) {
		this._representationStandard = _representationStandard_;
	}

	@JsonProperty("ids:language")
	final public Language getLanguage() {
		return _language;
	}
	
	final public void setLanguage (Language _language_) {
		this._language = _language_;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSzzz")
	@JsonProperty("ids:created")
	final public XMLGregorianCalendar getCreated() {
		return _created;
	}
	
	final public void setCreated (XMLGregorianCalendar _created_) {
		this._created = _created_;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSzzz")
	@JsonProperty("ids:modified")
	final public XMLGregorianCalendar getModified() {
		return _modified;
	}
	
	final public void setModified (XMLGregorianCalendar _modified_) {
		this._modified = _modified_;
	}



	@JsonProperty("ids:shapesGraph")
	final public URI getShapesGraph() {
		return _shapesGraph;
	}
	
	final public void setShapesGraph (URI _shapesGraph_) {
		this._shapesGraph = _shapesGraph_;
	}

}
