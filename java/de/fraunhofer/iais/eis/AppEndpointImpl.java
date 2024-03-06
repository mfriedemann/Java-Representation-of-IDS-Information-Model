package de.fraunhofer.iais.eis;

import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import de.fraunhofer.iais.eis.util.*;

/**
 * Default implementation of package de.fraunhofer.iais.eis.AppEndpoint
 * 
 * Description of endpoints a DataApp offers.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("ids:AppEndpoint")
public class AppEndpointImpl implements AppEndpoint {

    @JsonProperty("@id")
    @JsonAlias({"@id", "id"})
    @NotNull
    protected URI id;

    // List of all labels of this class
    @JsonIgnore
    protected List<TypedLiteral> label = Arrays.asList(new TypedLiteral("DataApp Endpoint", "en"));

    // List of all comments of this class
    @JsonIgnore
    protected List<TypedLiteral> comment = Arrays.asList(new TypedLiteral("Description of endpoints a DataApp offers.", "en"));

    // all classes have a generic property array
    @JsonIgnore
    protected Map<String, Object> properties;

    // instance fields as derived from the IDS Information Model ontology

    @JsonAlias({"ids:accessURL", "accessURL"})
    protected URI _accessURL;

    @JsonAlias({"ids:appEndpointMediaType", "appEndpointMediaType"})
    protected MediaType _appEndpointMediaType;

    @JsonAlias({"ids:appEndpointPort", "appEndpointPort"})
    protected BigInteger _appEndpointPort;

    @JsonAlias({"ids:appEndpointProtocol", "appEndpointProtocol"})
    protected String _appEndpointProtocol;

    @NotNull
    @JsonAlias({"ids:appEndpointType", "appEndpointType"})
    protected AppEndpointType _appEndpointType;

    @JsonAlias({"ids:endpointDocumentation", "endpointDocumentation"})
    protected List<URI> _endpointDocumentation = new ArrayList<>();

    @JsonAlias({"ids:endpointInformation", "endpointInformation"})
    protected List<TypedLiteral> _endpointInformation = new ArrayList<>();

    @JsonAlias({"ids:inboundPath", "inboundPath"})
    protected String _inboundPath;

    @JsonAlias({"ids:language", "language"})
    protected Language _language;

    @JsonAlias({"ids:outboundPath", "outboundPath"})
    protected String _outboundPath;

    @JsonAlias({"ids:path", "path"})
    protected String _path;

    protected AppEndpointImpl() {
        id = VocabUtil.getInstance().createRandomUrl("appEndpoint");
    }

    @JsonProperty("@id")
    final public URI getId() {
        return id;
    }

    public String toRdf() {
        return VocabUtil.getInstance().toRdf(this);
    }

    @Override
    public String toString() {
        return this.toRdf();
    }

    public List<TypedLiteral> getLabel() {
        return this.label;
    }

    public List<TypedLiteral> getComment() {
        return this.comment;
    }

    // getter and setter for generic property map
    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        if (this.properties == null)
            return null;
        Iterator<String> iter = this.properties.keySet().iterator();
        Map<String, Object> resultset = new HashMap<String, Object>();
        while (iter.hasNext()) {
            String key = iter.next();
            resultset.put(key, urifyObjects(this.properties.get(key)));
        }
        return resultset;
    }

    public Object urifyObjects(Object value) {
        if (value instanceof String && value.toString().startsWith("http")) {
            try {
                value = new URI(value.toString());
            } catch (Exception e) {
                /* do nothing */ }
        } else if (value instanceof ArrayList) {
            ArrayList<Object> result_array = new ArrayList<Object>();
            ((ArrayList) value).forEach(x -> result_array.add(urifyObjects(x)));
            return result_array;
        } else if (value instanceof Map) {
            Map<String, Object> result_map = new HashMap<String, Object>();
            ((Map) value).forEach((k, v) -> result_map.put(k.toString(), urifyObjects(v)));
            return result_map;
        }
        return value;
    }

    @JsonAnySetter
    public void setProperty(String property, Object value) {
        if (this.properties == null)
            this.properties = new HashMap<String, Object>();
        if (property.startsWith("@")) {
            return;
        } ;
        this.properties.put(property, value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this._appEndpointType,
            this._appEndpointPort,
            this._appEndpointMediaType,
            this._appEndpointProtocol,
            this._language,
            this._accessURL,
            this._endpointInformation,
            this._endpointDocumentation,
            this._path,
            this._inboundPath,
            this._outboundPath);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            AppEndpointImpl other = (AppEndpointImpl) obj;
            return Objects.equals(this._appEndpointType, other._appEndpointType) &&
                Objects.equals(this._appEndpointPort, other._appEndpointPort) &&
                Objects.equals(this._appEndpointMediaType, other._appEndpointMediaType) &&
                Objects.equals(this._appEndpointProtocol, other._appEndpointProtocol) &&
                Objects.equals(this._language, other._language) &&
                Objects.equals(this._accessURL, other._accessURL) &&
                Objects.equals(this._endpointInformation, other._endpointInformation) &&
                Objects.equals(this._endpointDocumentation, other._endpointDocumentation) &&
                Objects.equals(this._path, other._path) &&
                Objects.equals(this._inboundPath, other._inboundPath) &&
                Objects.equals(this._outboundPath, other._outboundPath);
        }
    }

    @Override
    public AppEndpoint deepCopy() {
        AppEndpointBuilder builder = new AppEndpointBuilder();
        builder._appEndpointType_(this._appEndpointType);
        builder._appEndpointPort_(this._appEndpointPort);
        if (this._appEndpointMediaType != null) {
            builder._appEndpointMediaType_(this._appEndpointMediaType.deepCopy());
        }
        builder._appEndpointProtocol_(this._appEndpointProtocol);
        builder._language_(this._language);
        if (this._accessURL != null) {
            builder._accessURL_(URI.create(this._accessURL.toString()));
        }
        for (TypedLiteral item : this._endpointInformation) {
            if (item != null && item.getLanguage() != null) {
                builder._endpointInformation_(new TypedLiteral(item.getValue(), item.getLanguage()));
            } else {
                builder._endpointInformation_(new TypedLiteral(item.getValue(), URI.create(item.getType())));
            }
        }
        for (URI item : this._endpointDocumentation) {
            if (item != null) {
                builder._endpointDocumentation_(URI.create(item.toString()));
            }
        }
        builder._path_(this._path);
        builder._inboundPath_(this._inboundPath);
        builder._outboundPath_(this._outboundPath);
        return builder.build();
    }

    // accessor method implementations as derived from the IDS Information Model ontology

    @Override
    @NotNull
    public AppEndpointType getAppEndpointType() {
        return _appEndpointType;
    }

    @Override
    public void setAppEndpointType(AppEndpointType _appEndpointType_) {
        this._appEndpointType = _appEndpointType_;
    }

    @Override
    public BigInteger getAppEndpointPort() {
        return _appEndpointPort;
    }

    @Override
    public void setAppEndpointPort(BigInteger _appEndpointPort_) {
        this._appEndpointPort = _appEndpointPort_;
    }

    @Override
    public MediaType getAppEndpointMediaType() {
        return _appEndpointMediaType;
    }

    @Override
    public void setAppEndpointMediaType(MediaType _appEndpointMediaType_) {
        this._appEndpointMediaType = _appEndpointMediaType_;
    }

    @Override
    public String getAppEndpointProtocol() {
        return _appEndpointProtocol;
    }

    @Override
    public void setAppEndpointProtocol(String _appEndpointProtocol_) {
        this._appEndpointProtocol = _appEndpointProtocol_;
    }

    @Override
    public Language getLanguage() {
        return _language;
    }

    @Override
    public void setLanguage(Language _language_) {
        this._language = _language_;
    }

    @Override
    public URI getAccessURL() {
        return _accessURL;
    }

    @Override
    public void setAccessURL(URI _accessURL_) {
        this._accessURL = _accessURL_;
    }

    @Override
    public List<TypedLiteral> getEndpointInformation() {
        return _endpointInformation;
    }

    @Override
    public void setEndpointInformation(List<TypedLiteral> _endpointInformation_) {
        this._endpointInformation = _endpointInformation_;
    }

    @Override
    public List<URI> getEndpointDocumentation() {
        return _endpointDocumentation;
    }

    @Override
    public void setEndpointDocumentation(List<URI> _endpointDocumentation_) {
        this._endpointDocumentation = _endpointDocumentation_;
    }

    @Override
    public String getPath() {
        return _path;
    }

    @Override
    public void setPath(String _path_) {
        this._path = _path_;
    }

    @Override
    public String getInboundPath() {
        return _inboundPath;
    }

    @Override
    public void setInboundPath(String _inboundPath_) {
        this._inboundPath = _inboundPath_;
    }

    @Override
    public String getOutboundPath() {
        return _outboundPath;
    }

    @Override
    public void setOutboundPath(String _outboundPath_) {
        this._outboundPath = _outboundPath_;
    }
}