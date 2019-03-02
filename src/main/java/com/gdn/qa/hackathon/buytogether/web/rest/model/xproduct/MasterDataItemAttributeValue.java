
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attributeValue",
    "masterDataAttribute"
})
public class MasterDataItemAttributeValue {

    @JsonProperty("attributeValue")
    private String attributeValue;
    @JsonProperty("masterDataAttribute")
    private MasterDataAttribute_ masterDataAttribute;

    @JsonProperty("attributeValue")
    public String getAttributeValue() {
        return attributeValue;
    }

    @JsonProperty("attributeValue")
    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @JsonProperty("masterDataAttribute")
    public MasterDataAttribute_ getMasterDataAttribute() {
        return masterDataAttribute;
    }

    @JsonProperty("masterDataAttribute")
    public void setMasterDataAttribute(MasterDataAttribute_ masterDataAttribute) {
        this.masterDataAttribute = masterDataAttribute;
    }

}
