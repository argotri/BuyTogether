
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "catalogCode",
    "category"
})
public class MasterCatalog {

    @JsonProperty("catalogCode")
    private String catalogCode;
    @JsonProperty("category")
    private Category category;

    @JsonProperty("catalogCode")
    public String getCatalogCode() {
        return catalogCode;
    }

    @JsonProperty("catalogCode")
    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

}
