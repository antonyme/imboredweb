
package com.advencedjava.api.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uid",
    "link",
    "updatedAt",
    "spacetimeinfo",
    "image",
    "imageThumb",
    "title",
    "description",
    "freeText",
    "tags",
    "locations",
    "thirdParties"
})
public class Datum implements Serializable
{

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("link")
    private String link;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("spacetimeinfo")
    private String spacetimeinfo;
    @JsonProperty("image")
    private Object image;
    @JsonProperty("imageThumb")
    private Object imageThumb;
    @JsonProperty("title")
    private Title title;
    @JsonProperty("description")
    private Description description;
    @JsonProperty("freeText")
    private FreeText freeText;
    @JsonProperty("tags")
    private Tags tags;
    @JsonProperty("locations")
    private List<Location> locations = null;
    @JsonProperty("thirdParties")
    private List<Object> thirdParties = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7756826344014162608L;

    /**
     * 
     * @return
     *     The uid
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * 
     * @param uid
     *     The uid
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 
     * @return
     *     The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The updatedAt
     */
    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     * @param updatedAt
     *     The updatedAt
     */
    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * @return
     *     The spacetimeinfo
     */
    @JsonProperty("spacetimeinfo")
    public String getSpacetimeinfo() {
        return spacetimeinfo;
    }

    /**
     * 
     * @param spacetimeinfo
     *     The spacetimeinfo
     */
    @JsonProperty("spacetimeinfo")
    public void setSpacetimeinfo(String spacetimeinfo) {
        this.spacetimeinfo = spacetimeinfo;
    }

    /**
     * 
     * @return
     *     The image
     */
    @JsonProperty("image")
    public Object getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    @JsonProperty("image")
    public void setImage(Object image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The imageThumb
     */
    @JsonProperty("imageThumb")
    public Object getImageThumb() {
        return imageThumb;
    }

    /**
     * 
     * @param imageThumb
     *     The imageThumb
     */
    @JsonProperty("imageThumb")
    public void setImageThumb(Object imageThumb) {
        this.imageThumb = imageThumb;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The freeText
     */
    @JsonProperty("freeText")
    public FreeText getFreeText() {
        return freeText;
    }

    /**
     * 
     * @param freeText
     *     The freeText
     */
    @JsonProperty("freeText")
    public void setFreeText(FreeText freeText) {
        this.freeText = freeText;
    }

    /**
     * 
     * @return
     *     The tags
     */
    @JsonProperty("tags")
    public Tags getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    @JsonProperty("tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The locations
     */
    @JsonProperty("locations")
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * 
     * @param locations
     *     The locations
     */
    @JsonProperty("locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * 
     * @return
     *     The thirdParties
     */
    @JsonProperty("thirdParties")
    public List<Object> getThirdParties() {
        return thirdParties;
    }

    /**
     * 
     * @param thirdParties
     *     The thirdParties
     */
    @JsonProperty("thirdParties")
    public void setThirdParties(List<Object> thirdParties) {
        this.thirdParties = thirdParties;
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
