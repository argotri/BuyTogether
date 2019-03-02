
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attributeType",
    "mandatory",
    "attributeName",
    "description",
    "attributeCode",
    "example",
    "searchable",
    "skuValue"
})
public class MasterDataAttribute {

    @JsonProperty("attributeType")
    private String attributeType;
    @JsonProperty("mandatory")
    private Boolean mandatory;
    @JsonProperty("attributeName")
    private String attributeName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("attributeCode")
    private String attributeCode;
    @JsonProperty("example")
    private Object example;
    @JsonProperty("searchable")
    private Boolean searchable;
    @JsonProperty("skuValue")
    private Boolean skuValue;

    @JsonProperty("attributeType")
    public String getAttributeType() {
        return attributeType;
    }

    @JsonProperty("attributeType")
    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    @JsonProperty("mandatory")
    public Boolean getMandatory() {
        return mandatory;
    }

    @JsonProperty("mandatory")
    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    @JsonProperty("attributeName")
    public String getAttributeName() {
        return attributeName;
    }

    @JsonProperty("attributeName")
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("attributeCode")
    public String getAttributeCode() {
        return attributeCode;
    }

    @JsonProperty("attributeCode")
    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    @JsonProperty("example")
    public Object getExample() {
        return example;
    }

    @JsonProperty("example")
    public void setExample(Object example) {
        this.example = example;
    }

    @JsonProperty("searchable")
    public Boolean getSearchable() {
        return searchable;
    }

    @JsonProperty("searchable")
    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    @JsonProperty("skuValue")
    public Boolean getSkuValue() {
        return skuValue;
    }

    @JsonProperty("skuValue")
    public void setSkuValue(Boolean skuValue) {
        this.skuValue = skuValue;
    }

}
