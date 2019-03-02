
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "storeId",
    "createdDate",
    "createdBy",
    "updatedDate",
    "updatedBy",
    "version",
    "merchantCode",
    "itemSku",
    "productSku",
    "merchantSku",
    "itemCode",
    "itemCatentryId",
    "masterDataItem",
    "pristineDataItem",
    "price",
    "itemViewConfigs",
    "isLateFulfillment",
    "pickupPointCode",
    "ticketTemplateCode",
    "etdNote",
    "off2OnChannelActive",
    "promoBundling",
    "cncActivated",
    "activePromoBundlings",
    "uniqueId",
    "offlineItems",
    "lateFulfillment",
    "synchronized",
    "archived"
})
public class Item {

    @JsonProperty("id")
    private String id;
    @JsonProperty("storeId")
    private String storeId;
    @JsonProperty("createdDate")
    private Long createdDate;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("updatedDate")
    private Long updatedDate;
    @JsonProperty("updatedBy")
    private String updatedBy;
    @JsonProperty("version")
    private Long version;
    @JsonProperty("merchantCode")
    private String merchantCode;
    @JsonProperty("itemSku")
    private String itemSku;
    @JsonProperty("productSku")
    private String productSku;
    @JsonProperty("merchantSku")
    private Object merchantSku;
    @JsonProperty("itemCode")
    private String itemCode;
    @JsonProperty("itemCatentryId")
    private String itemCatentryId;
    @JsonProperty("masterDataItem")
    private MasterDataItem masterDataItem;
    @JsonProperty("pristineDataItem")
    private Object pristineDataItem;
    @JsonProperty("price")
    private List<Price> price = null;
    @JsonProperty("itemViewConfigs")
    private List<ItemViewConfig> itemViewConfigs = null;
    @JsonProperty("isLateFulfillment")
    private Boolean isLateFulfillment;
    @JsonProperty("pickupPointCode")
    private String pickupPointCode;
    @JsonProperty("ticketTemplateCode")
    private Object ticketTemplateCode;
    @JsonProperty("etdNote")
    private Object etdNote;
    @JsonProperty("off2OnChannelActive")
    private Boolean off2OnChannelActive;
    @JsonProperty("promoBundling")
    private Boolean promoBundling;
    @JsonProperty("cncActivated")
    private Boolean cncActivated;
    @JsonProperty("activePromoBundlings")
    private Object activePromoBundlings;
    @JsonProperty("uniqueId")
    private String uniqueId;
    @JsonProperty("offlineItems")
    private Object offlineItems;
    @JsonProperty("lateFulfillment")
    private Boolean lateFulfillment;
    @JsonProperty("synchronized")
    private Boolean _synchronized;
    @JsonProperty("archived")
    private Boolean archived;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("storeId")
    public String getStoreId() {
        return storeId;
    }

    @JsonProperty("storeId")
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @JsonProperty("createdDate")
    public Long getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("updatedDate")
    public Long getUpdatedDate() {
        return updatedDate;
    }

    @JsonProperty("updatedDate")
    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    @JsonProperty("updatedBy")
    public String getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty("updatedBy")
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    @JsonProperty("merchantCode")
    public String getMerchantCode() {
        return merchantCode;
    }

    @JsonProperty("merchantCode")
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @JsonProperty("itemSku")
    public String getItemSku() {
        return itemSku;
    }

    @JsonProperty("itemSku")
    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    @JsonProperty("productSku")
    public String getProductSku() {
        return productSku;
    }

    @JsonProperty("productSku")
    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    @JsonProperty("merchantSku")
    public Object getMerchantSku() {
        return merchantSku;
    }

    @JsonProperty("merchantSku")
    public void setMerchantSku(Object merchantSku) {
        this.merchantSku = merchantSku;
    }

    @JsonProperty("itemCode")
    public String getItemCode() {
        return itemCode;
    }

    @JsonProperty("itemCode")
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @JsonProperty("itemCatentryId")
    public String getItemCatentryId() {
        return itemCatentryId;
    }

    @JsonProperty("itemCatentryId")
    public void setItemCatentryId(String itemCatentryId) {
        this.itemCatentryId = itemCatentryId;
    }

    @JsonProperty("masterDataItem")
    public MasterDataItem getMasterDataItem() {
        return masterDataItem;
    }

    @JsonProperty("masterDataItem")
    public void setMasterDataItem(MasterDataItem masterDataItem) {
        this.masterDataItem = masterDataItem;
    }

    @JsonProperty("pristineDataItem")
    public Object getPristineDataItem() {
        return pristineDataItem;
    }

    @JsonProperty("pristineDataItem")
    public void setPristineDataItem(Object pristineDataItem) {
        this.pristineDataItem = pristineDataItem;
    }

    @JsonProperty("price")
    public List<Price> getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(List<Price> price) {
        this.price = price;
    }

    @JsonProperty("itemViewConfigs")
    public List<ItemViewConfig> getItemViewConfigs() {
        return itemViewConfigs;
    }

    @JsonProperty("itemViewConfigs")
    public void setItemViewConfigs(List<ItemViewConfig> itemViewConfigs) {
        this.itemViewConfigs = itemViewConfigs;
    }

    @JsonProperty("isLateFulfillment")
    public Boolean getIsLateFulfillment() {
        return isLateFulfillment;
    }

    @JsonProperty("isLateFulfillment")
    public void setIsLateFulfillment(Boolean isLateFulfillment) {
        this.isLateFulfillment = isLateFulfillment;
    }

    @JsonProperty("pickupPointCode")
    public String getPickupPointCode() {
        return pickupPointCode;
    }

    @JsonProperty("pickupPointCode")
    public void setPickupPointCode(String pickupPointCode) {
        this.pickupPointCode = pickupPointCode;
    }

    @JsonProperty("ticketTemplateCode")
    public Object getTicketTemplateCode() {
        return ticketTemplateCode;
    }

    @JsonProperty("ticketTemplateCode")
    public void setTicketTemplateCode(Object ticketTemplateCode) {
        this.ticketTemplateCode = ticketTemplateCode;
    }

    @JsonProperty("etdNote")
    public Object getEtdNote() {
        return etdNote;
    }

    @JsonProperty("etdNote")
    public void setEtdNote(Object etdNote) {
        this.etdNote = etdNote;
    }

    @JsonProperty("off2OnChannelActive")
    public Boolean getOff2OnChannelActive() {
        return off2OnChannelActive;
    }

    @JsonProperty("off2OnChannelActive")
    public void setOff2OnChannelActive(Boolean off2OnChannelActive) {
        this.off2OnChannelActive = off2OnChannelActive;
    }

    @JsonProperty("promoBundling")
    public Boolean getPromoBundling() {
        return promoBundling;
    }

    @JsonProperty("promoBundling")
    public void setPromoBundling(Boolean promoBundling) {
        this.promoBundling = promoBundling;
    }

    @JsonProperty("cncActivated")
    public Boolean getCncActivated() {
        return cncActivated;
    }

    @JsonProperty("cncActivated")
    public void setCncActivated(Boolean cncActivated) {
        this.cncActivated = cncActivated;
    }

    @JsonProperty("activePromoBundlings")
    public Object getActivePromoBundlings() {
        return activePromoBundlings;
    }

    @JsonProperty("activePromoBundlings")
    public void setActivePromoBundlings(Object activePromoBundlings) {
        this.activePromoBundlings = activePromoBundlings;
    }

    @JsonProperty("uniqueId")
    public String getUniqueId() {
        return uniqueId;
    }

    @JsonProperty("uniqueId")
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonProperty("offlineItems")
    public Object getOfflineItems() {
        return offlineItems;
    }

    @JsonProperty("offlineItems")
    public void setOfflineItems(Object offlineItems) {
        this.offlineItems = offlineItems;
    }

    @JsonProperty("lateFulfillment")
    public Boolean getLateFulfillment() {
        return lateFulfillment;
    }

    @JsonProperty("lateFulfillment")
    public void setLateFulfillment(Boolean lateFulfillment) {
        this.lateFulfillment = lateFulfillment;
    }

    @JsonProperty("synchronized")
    public Boolean getSynchronized() {
        return _synchronized;
    }

    @JsonProperty("synchronized")
    public void setSynchronized(Boolean _synchronized) {
        this._synchronized = _synchronized;
    }

    @JsonProperty("archived")
    public Boolean getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

}
