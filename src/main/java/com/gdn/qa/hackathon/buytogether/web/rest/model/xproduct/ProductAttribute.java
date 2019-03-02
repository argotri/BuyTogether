
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "itemSku",
    "productAttributeDetails"
})
public class ProductAttribute {

    @JsonProperty("itemSku")
    private String itemSku;
    @JsonProperty("productAttributeDetails")
    private List<Object> productAttributeDetails = null;

    @JsonProperty("itemSku")
    public String getItemSku() {
        return itemSku;
    }

    @JsonProperty("itemSku")
    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    @JsonProperty("productAttributeDetails")
    public List<Object> getProductAttributeDetails() {
        return productAttributeDetails;
    }

    @JsonProperty("productAttributeDetails")
    public void setProductAttributeDetails(List<Object> productAttributeDetails) {
        this.productAttributeDetails = productAttributeDetails;
    }

}
