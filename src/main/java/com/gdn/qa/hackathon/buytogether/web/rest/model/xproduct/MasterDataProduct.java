
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "brand",
    "shippingWeight",
    "specificationDetail",
    "productName",
    "description",
    "longDescription",
    "uniqueSellingPoint",
    "productStory",
    "uom",
    "masterDataProductImages",
    "masterDataProductAttributes",
    "sortedDefiningAttributes",
    "url",
    "brandLogoUrl",
    "activated",
    "viewable"
})
public class MasterDataProduct {

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("shippingWeight")
    private Float shippingWeight;
    @JsonProperty("specificationDetail")
    private String specificationDetail;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("longDescription")
    private String longDescription;
    @JsonProperty("uniqueSellingPoint")
    private String uniqueSellingPoint;
    @JsonProperty("productStory")
    private String productStory;
    @JsonProperty("uom")
    private String uom;
    @JsonProperty("masterDataProductImages")
    private List<MasterDataProductImage> masterDataProductImages = null;
    @JsonProperty("masterDataProductAttributes")
    private List<MasterDataProductAttribute> masterDataProductAttributes = null;
    @JsonProperty("sortedDefiningAttributes")
    private List<Object> sortedDefiningAttributes = null;
    @JsonProperty("url")
    private Object url;
    @JsonProperty("brandLogoUrl")
    private String brandLogoUrl;
    @JsonProperty("activated")
    private Boolean activated;
    @JsonProperty("viewable")
    private Boolean viewable;

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("shippingWeight")
    public Float getShippingWeight() {
        return shippingWeight;
    }

    @JsonProperty("shippingWeight")
    public void setShippingWeight(Float shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    @JsonProperty("specificationDetail")
    public String getSpecificationDetail() {
        return specificationDetail;
    }

    @JsonProperty("specificationDetail")
    public void setSpecificationDetail(String specificationDetail) {
        this.specificationDetail = specificationDetail;
    }

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    @JsonProperty("longDescription")
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @JsonProperty("uniqueSellingPoint")
    public String getUniqueSellingPoint() {
        return uniqueSellingPoint;
    }

    @JsonProperty("uniqueSellingPoint")
    public void setUniqueSellingPoint(String uniqueSellingPoint) {
        this.uniqueSellingPoint = uniqueSellingPoint;
    }

    @JsonProperty("productStory")
    public String getProductStory() {
        return productStory;
    }

    @JsonProperty("productStory")
    public void setProductStory(String productStory) {
        this.productStory = productStory;
    }

    @JsonProperty("uom")
    public String getUom() {
        return uom;
    }

    @JsonProperty("uom")
    public void setUom(String uom) {
        this.uom = uom;
    }

    @JsonProperty("masterDataProductImages")
    public List<MasterDataProductImage> getMasterDataProductImages() {
        return masterDataProductImages;
    }

    @JsonProperty("masterDataProductImages")
    public void setMasterDataProductImages(List<MasterDataProductImage> masterDataProductImages) {
        this.masterDataProductImages = masterDataProductImages;
    }

    @JsonProperty("masterDataProductAttributes")
    public List<MasterDataProductAttribute> getMasterDataProductAttributes() {
        return masterDataProductAttributes;
    }

    @JsonProperty("masterDataProductAttributes")
    public void setMasterDataProductAttributes(List<MasterDataProductAttribute> masterDataProductAttributes) {
        this.masterDataProductAttributes = masterDataProductAttributes;
    }

    @JsonProperty("sortedDefiningAttributes")
    public List<Object> getSortedDefiningAttributes() {
        return sortedDefiningAttributes;
    }

    @JsonProperty("sortedDefiningAttributes")
    public void setSortedDefiningAttributes(List<Object> sortedDefiningAttributes) {
        this.sortedDefiningAttributes = sortedDefiningAttributes;
    }

    @JsonProperty("url")
    public Object getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(Object url) {
        this.url = url;
    }

    @JsonProperty("brandLogoUrl")
    public String getBrandLogoUrl() {
        return brandLogoUrl;
    }

    @JsonProperty("brandLogoUrl")
    public void setBrandLogoUrl(String brandLogoUrl) {
        this.brandLogoUrl = brandLogoUrl;
    }

    @JsonProperty("activated")
    public Boolean getActivated() {
        return activated;
    }

    @JsonProperty("activated")
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    @JsonProperty("viewable")
    public Boolean getViewable() {
        return viewable;
    }

    @JsonProperty("viewable")
    public void setViewable(Boolean viewable) {
        this.viewable = viewable;
    }

}
