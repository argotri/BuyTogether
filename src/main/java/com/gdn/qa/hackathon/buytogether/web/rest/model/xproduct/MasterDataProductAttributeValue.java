
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descriptiveAttributeValue",
    "descriptiveAttributeValueType",
    "predefinedAllowedAttributeValue",
    "allowedAttributeValue",
    "sequence",
    "markForDelete"
})
public class MasterDataProductAttributeValue {

    @JsonProperty("descriptiveAttributeValue")
    private String descriptiveAttributeValue;
    @JsonProperty("descriptiveAttributeValueType")
    private String descriptiveAttributeValueType;
    @JsonProperty("predefinedAllowedAttributeValue")
    private Object predefinedAllowedAttributeValue;
    @JsonProperty("allowedAttributeValue")
    private Object allowedAttributeValue;
    @JsonProperty("sequence")
    private Long sequence;
    @JsonProperty("markForDelete")
    private Boolean markForDelete;

    @JsonProperty("descriptiveAttributeValue")
    public String getDescriptiveAttributeValue() {
        return descriptiveAttributeValue;
    }

    @JsonProperty("descriptiveAttributeValue")
    public void setDescriptiveAttributeValue(String descriptiveAttributeValue) {
        this.descriptiveAttributeValue = descriptiveAttributeValue;
    }

    @JsonProperty("descriptiveAttributeValueType")
    public String getDescriptiveAttributeValueType() {
        return descriptiveAttributeValueType;
    }

    @JsonProperty("descriptiveAttributeValueType")
    public void setDescriptiveAttributeValueType(String descriptiveAttributeValueType) {
        this.descriptiveAttributeValueType = descriptiveAttributeValueType;
    }

    @JsonProperty("predefinedAllowedAttributeValue")
    public Object getPredefinedAllowedAttributeValue() {
        return predefinedAllowedAttributeValue;
    }

    @JsonProperty("predefinedAllowedAttributeValue")
    public void setPredefinedAllowedAttributeValue(Object predefinedAllowedAttributeValue) {
        this.predefinedAllowedAttributeValue = predefinedAllowedAttributeValue;
    }

    @JsonProperty("allowedAttributeValue")
    public Object getAllowedAttributeValue() {
        return allowedAttributeValue;
    }

    @JsonProperty("allowedAttributeValue")
    public void setAllowedAttributeValue(Object allowedAttributeValue) {
        this.allowedAttributeValue = allowedAttributeValue;
    }

    @JsonProperty("sequence")
    public Long getSequence() {
        return sequence;
    }

    @JsonProperty("sequence")
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @JsonProperty("markForDelete")
    public Boolean getMarkForDelete() {
        return markForDelete;
    }

    @JsonProperty("markForDelete")
    public void setMarkForDelete(Boolean markForDelete) {
        this.markForDelete = markForDelete;
    }

}
