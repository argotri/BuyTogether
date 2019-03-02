
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "locationPath",
    "sequence",
    "mainImage"
})
public class MasterDataItemImage {

    @JsonProperty("locationPath")
    private String locationPath;
    @JsonProperty("sequence")
    private Long sequence;
    @JsonProperty("mainImage")
    private Boolean mainImage;

    @JsonProperty("locationPath")
    public String getLocationPath() {
        return locationPath;
    }

    @JsonProperty("locationPath")
    public void setLocationPath(String locationPath) {
        this.locationPath = locationPath;
    }

    @JsonProperty("sequence")
    public Long getSequence() {
        return sequence;
    }

    @JsonProperty("sequence")
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @JsonProperty("mainImage")
    public Boolean getMainImage() {
        return mainImage;
    }

    @JsonProperty("mainImage")
    public void setMainImage(Boolean mainImage) {
        this.mainImage = mainImage;
    }

}
