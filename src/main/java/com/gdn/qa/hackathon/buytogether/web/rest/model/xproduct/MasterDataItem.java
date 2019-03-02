
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "skuCode",
    "generatedItemName",
    "upcCode",
    "hash",
    "dangerousLevel",
    "inventoryType",
    "masterDataItemAttributeValues",
    "masterDataItemImages",
    "itemDeliveryWeight",
    "itemHeight",
    "itemLength",
    "itemWeight",
    "itemWidth",
    "productCode",
    "activated",
    "viewable"
})
public class MasterDataItem {

    @JsonProperty("skuCode")
    private String skuCode;
    @JsonProperty("generatedItemName")
    private String generatedItemName;
    @JsonProperty("upcCode")
    private String upcCode;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("dangerousLevel")
    private Long dangerousLevel;
    @JsonProperty("inventoryType")
    private Object inventoryType;
    @JsonProperty("masterDataItemAttributeValues")
    private List<MasterDataItemAttributeValue> masterDataItemAttributeValues = null;
    @JsonProperty("masterDataItemImages")
    private List<MasterDataItemImage> masterDataItemImages = null;
    @JsonProperty("itemDeliveryWeight")
    private Float itemDeliveryWeight;
    @JsonProperty("itemHeight")
    private Long itemHeight;
    @JsonProperty("itemLength")
    private Long itemLength;
    @JsonProperty("itemWeight")
    private Float itemWeight;
    @JsonProperty("itemWidth")
    private Long itemWidth;
    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("activated")
    private Boolean activated;
    @JsonProperty("viewable")
    private Boolean viewable;

    @JsonProperty("skuCode")
    public String getSkuCode() {
        return skuCode;
    }

    @JsonProperty("skuCode")
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    @JsonProperty("generatedItemName")
    public String getGeneratedItemName() {
        return generatedItemName;
    }

    @JsonProperty("generatedItemName")
    public void setGeneratedItemName(String generatedItemName) {
        this.generatedItemName = generatedItemName;
    }

    @JsonProperty("upcCode")
    public String getUpcCode() {
        return upcCode;
    }

    @JsonProperty("upcCode")
    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("dangerousLevel")
    public Long getDangerousLevel() {
        return dangerousLevel;
    }

    @JsonProperty("dangerousLevel")
    public void setDangerousLevel(Long dangerousLevel) {
        this.dangerousLevel = dangerousLevel;
    }

    @JsonProperty("inventoryType")
    public Object getInventoryType() {
        return inventoryType;
    }

    @JsonProperty("inventoryType")
    public void setInventoryType(Object inventoryType) {
        this.inventoryType = inventoryType;
    }

    @JsonProperty("masterDataItemAttributeValues")
    public List<MasterDataItemAttributeValue> getMasterDataItemAttributeValues() {
        return masterDataItemAttributeValues;
    }

    @JsonProperty("masterDataItemAttributeValues")
    public void setMasterDataItemAttributeValues(List<MasterDataItemAttributeValue> masterDataItemAttributeValues) {
        this.masterDataItemAttributeValues = masterDataItemAttributeValues;
    }

    @JsonProperty("masterDataItemImages")
    public List<MasterDataItemImage> getMasterDataItemImages() {
        return masterDataItemImages;
    }

    @JsonProperty("masterDataItemImages")
    public void setMasterDataItemImages(List<MasterDataItemImage> masterDataItemImages) {
        this.masterDataItemImages = masterDataItemImages;
    }

    @JsonProperty("itemDeliveryWeight")
    public Float getItemDeliveryWeight() {
        return itemDeliveryWeight;
    }

    @JsonProperty("itemDeliveryWeight")
    public void setItemDeliveryWeight(Float itemDeliveryWeight) {
        this.itemDeliveryWeight = itemDeliveryWeight;
    }

    @JsonProperty("itemHeight")
    public Long getItemHeight() {
        return itemHeight;
    }

    @JsonProperty("itemHeight")
    public void setItemHeight(Long itemHeight) {
        this.itemHeight = itemHeight;
    }

    @JsonProperty("itemLength")
    public Long getItemLength() {
        return itemLength;
    }

    @JsonProperty("itemLength")
    public void setItemLength(Long itemLength) {
        this.itemLength = itemLength;
    }

    @JsonProperty("itemWeight")
    public Float getItemWeight() {
        return itemWeight;
    }

    @JsonProperty("itemWeight")
    public void setItemWeight(Float itemWeight) {
        this.itemWeight = itemWeight;
    }

    @JsonProperty("itemWidth")
    public Long getItemWidth() {
        return itemWidth;
    }

    @JsonProperty("itemWidth")
    public void setItemWidth(Long itemWidth) {
        this.itemWidth = itemWidth;
    }

    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("productCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
