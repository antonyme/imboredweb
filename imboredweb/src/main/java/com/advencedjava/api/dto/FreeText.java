
package com.advencedjava.api.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fr"
})
public class FreeText implements Serializable
{

    @JsonProperty("fr")
    private Object fr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8557976060391689001L;

    /**
     * 
     * @return
     *     The fr
     */
    @JsonProperty("fr")
    public Object getFr() {
        return fr;
    }

    /**
     * 
     * @param fr
     *     The fr
     */
    @JsonProperty("fr")
    public void setFr(Object fr) {
        this.fr = fr;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
