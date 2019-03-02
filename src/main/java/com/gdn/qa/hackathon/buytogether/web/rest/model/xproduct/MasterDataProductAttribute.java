
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "masterDataAttribute",
    "sequence",
    "masterDataProductAttributeValues",
    "ownedByProductItem"
})
public class MasterDataProductAttribute {

    @JsonProperty("masterDataAttribute")
    private MasterDataAttribute masterDataAttribute;
    @JsonProperty("sequence")
    private Long sequence;
    @JsonProperty("masterDataProductAttributeValues")
    private List<MasterDataProductAttributeValue> masterDataProductAttributeValues = null;
    @JsonProperty("ownedByProductItem")
    private Boolean ownedByProductItem;

    @JsonProperty("masterDataAttribute")
    public MasterDataAttribute getMasterDataAttribute() {
        return masterDataAttribute;
    }

    @JsonProperty("masterDataAttribute")
    public void setMasterDataAttribute(MasterDataAttribute masterDataAttribute) {
        this.masterDataAttribute = masterDataAttribute;
    }

    @JsonProperty("sequence")
    public Long getSequence() {
        return sequence;
    }

    @JsonProperty("sequence")
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @JsonProperty("masterDataProductAttributeValues")
    public List<MasterDataProductAttributeValue> getMasterDataProductAttributeValues() {
        return masterDataProductAttributeValues;
    }

    @JsonProperty("masterDataProductAttributeValues")
    public void setMasterDataProductAttributeValues(List<MasterDataProductAttributeValue> masterDataProductAttributeValues) {
        this.masterDataProductAttributeValues = masterDataProductAttributeValues;
    }

    @JsonProperty("ownedByProductItem")
    public Boolean getOwnedByProductItem() {
        return ownedByProductItem;
    }

    @JsonProperty("ownedByProductItem")
    public void setOwnedByProductItem(Boolean ownedByProductItem) {
        this.ownedByProductItem = ownedByProductItem;
    }

}
