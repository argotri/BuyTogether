
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attributeCode",
    "attributeName",
    "attributeValue"
})
public class DescriptiveAttribute {

    @JsonProperty("attributeCode")
    private String attributeCode;
    @JsonProperty("attributeName")
    private String attributeName;
    @JsonProperty("attributeValue")
    private String attributeValue;

    @JsonProperty("attributeCode")
    public String getAttributeCode() {
        return attributeCode;
    }

    @JsonProperty("attributeCode")
    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    @JsonProperty("attributeName")
    public String getAttributeName() {
        return attributeName;
    }

    @JsonProperty("attributeName")
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @JsonProperty("attributeValue")
    public String getAttributeValue() {
        return attributeValue;
    }

    @JsonProperty("attributeValue")
    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

}
