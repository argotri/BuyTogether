
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "catalogCode",
    "listOfCategories"
})
public class SalesCatalog {

    @JsonProperty("catalogCode")
    private String catalogCode;
    @JsonProperty("listOfCategories")
    private List<ListOfCategory> listOfCategories = null;

    @JsonProperty("catalogCode")
    public String getCatalogCode() {
        return catalogCode;
    }

    @JsonProperty("catalogCode")
    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    @JsonProperty("listOfCategories")
    public List<ListOfCategory> getListOfCategories() {
        return listOfCategories;
    }

    @JsonProperty("listOfCategories")
    public void setListOfCategories(List<ListOfCategory> listOfCategories) {
        this.listOfCategories = listOfCategories;
    }

}
