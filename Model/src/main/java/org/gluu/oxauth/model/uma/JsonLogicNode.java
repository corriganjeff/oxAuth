package org.gluu.oxauth.model.uma;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuriyz
 */
@IgnoreMediaTypes("application/*+json") // try to ignore jettison as it's recommended here: http://docs.jboss.org/resteasy/docs/2.3.4.Final/userguide/html/json.html
@JsonPropertyOrder({ "ticket" })
@XmlRootElement
public class JsonLogicNode {

    private JsonNode rule;
    private List<String> data;

    public JsonLogicNode() {
    }

    public JsonLogicNode(JsonNode rule, List<String> data) {
        this.rule = rule;
        this.data = data;
    }

    @JsonIgnore
    public boolean isValid() {
        return data != null && !data.isEmpty() && rule != null;
    }

    @JsonProperty(value = "rule")
    @XmlElement(name = "rule")
    public JsonNode getRule() {
        return rule;
    }

    public void setRule(JsonNode rule) {
        this.rule = rule;
    }

    @JsonProperty(value = "data")
    @XmlElement(name = "data")
    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @JsonIgnore
    public List<String> getDataCopy() {
        if (data == null) {
            return new ArrayList<String>();
        }
        return new ArrayList<String>(data);
    }

    @Override
    public String toString() {
        return "JsonLogicNode{" +
                "rule=" + rule +
                ", data=" + data +
                '}';
    }
}
