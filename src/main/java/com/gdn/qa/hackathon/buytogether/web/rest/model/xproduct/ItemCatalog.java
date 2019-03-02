
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "catalogId",
    "itemCategories"
})
public class ItemCatalog {

    @JsonProperty("catalogId")
    private String catalogId;
    @JsonProperty("itemCategories")
    private List<ItemCategory> itemCategories = null;

    @JsonProperty("catalogId")
    public String getCatalogId() {
        return catalogId;
    }

    @JsonProperty("catalogId")
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    @JsonProperty("itemCategories")
    public List<ItemCategory> getItemCategories() {
        return itemCategories;
    }

    @JsonProperty("itemCategories")
    public void setItemCategories(List<ItemCategory> itemCategories) {
        this.itemCategories = itemCategories;
    }

}
