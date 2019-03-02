
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "categoryCode",
    "catgroupId"
})
public class ListOfCategory {

    @JsonProperty("categoryCode")
    private String categoryCode;
    @JsonProperty("catgroupId")
    private String catgroupId;

    @JsonProperty("categoryCode")
    public String getCategoryCode() {
        return categoryCode;
    }

    @JsonProperty("categoryCode")
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @JsonProperty("catgroupId")
    public String getCatgroupId() {
        return catgroupId;
    }

    @JsonProperty("catgroupId")
    public void setCatgroupId(String catgroupId) {
        this.catgroupId = catgroupId;
    }

}
