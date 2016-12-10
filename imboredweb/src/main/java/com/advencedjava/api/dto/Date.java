
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
    "date",
    "timeStart",
    "timeEnd"
})
public class Date implements Serializable
{

    @JsonProperty("date")
    private String date;
    @JsonProperty("timeStart")
    private String timeStart;
    @JsonProperty("timeEnd")
    private String timeEnd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7311125681200419468L;

    /**
     * 
     * @return
     *     The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The timeStart
     */
    @JsonProperty("timeStart")
    public String getTimeStart() {
        return timeStart;
    }

    /**
     * 
     * @param timeStart
     *     The timeStart
     */
    @JsonProperty("timeStart")
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    /**
     * 
     * @return
     *     The timeEnd
     */
    @JsonProperty("timeEnd")
    public String getTimeEnd() {
        return timeEnd;
    }

    /**
     * 
     * @param timeEnd
     *     The timeEnd
     */
    @JsonProperty("timeEnd")
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
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
