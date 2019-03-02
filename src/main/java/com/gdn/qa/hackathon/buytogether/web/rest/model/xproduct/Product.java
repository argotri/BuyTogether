
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
    "productSku",
    "productCode",
    "productType",
    "settlementType",
    "merchantCode",
    "productCatentryId",
    "masterCatalog",
    "salesCatalogs",
    "masterDataProduct",
    "definingAttributes",
    "descriptiveAttributes",
    "productSpecialAttributes",
    "itemCatalogs",
    "salesCategorySequences",
    "installationRequired",
    "off2OnChannelActive",
    "productAttributes",
    "synchronized"
})
public class Product {

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
    @JsonProperty("productSku")
    private String productSku;
    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("productType")
    private String productType;
    @JsonProperty("settlementType")
    private String settlementType;
    @JsonProperty("merchantCode")
    private String merchantCode;
    @JsonProperty("productCatentryId")
    private String productCatentryId;
    @JsonProperty("masterCatalog")
    private MasterCatalog masterCatalog;
    @JsonProperty("salesCatalogs")
    private List<SalesCatalog> salesCatalogs = null;
    @JsonProperty("masterDataProduct")
    private MasterDataProduct masterDataProduct;
    @JsonProperty("definingAttributes")
    private List<DefiningAttribute> definingAttributes = null;
    @JsonProperty("descriptiveAttributes")
    private List<DescriptiveAttribute> descriptiveAttributes = null;
    @JsonProperty("productSpecialAttributes")
    private List<ProductSpecialAttribute> productSpecialAttributes = null;
    @JsonProperty("itemCatalogs")
    private List<ItemCatalog> itemCatalogs = null;
    @JsonProperty("salesCategorySequences")
    private Object salesCategorySequences;
    @JsonProperty("installationRequired")
    private Boolean installationRequired;
    @JsonProperty("off2OnChannelActive")
    private Boolean off2OnChannelActive;
    @JsonProperty("productAttributes")
    private List<ProductAttribute> productAttributes = null;
    @JsonProperty("synchronized")
    private Boolean _synchronized;

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

    @JsonProperty("productSku")
    public String getProductSku() {
        return productSku;
    }

    @JsonProperty("productSku")
    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("productCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JsonProperty("productType")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("productType")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonProperty("settlementType")
    public String getSettlementType() {
        return settlementType;
    }

    @JsonProperty("settlementType")
    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    @JsonProperty("merchantCode")
    public String getMerchantCode() {
        return merchantCode;
    }

    @JsonProperty("merchantCode")
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @JsonProperty("productCatentryId")
    public String getProductCatentryId() {
        return productCatentryId;
    }

    @JsonProperty("productCatentryId")
    public void setProductCatentryId(String productCatentryId) {
        this.productCatentryId = productCatentryId;
    }

    @JsonProperty("masterCatalog")
    public MasterCatalog getMasterCatalog() {
        return masterCatalog;
    }

    @JsonProperty("masterCatalog")
    public void setMasterCatalog(MasterCatalog masterCatalog) {
        this.masterCatalog = masterCatalog;
    }

    @JsonProperty("salesCatalogs")
    public List<SalesCatalog> getSalesCatalogs() {
        return salesCatalogs;
    }

    @JsonProperty("salesCatalogs")
    public void setSalesCatalogs(List<SalesCatalog> salesCatalogs) {
        this.salesCatalogs = salesCatalogs;
    }

    @JsonProperty("masterDataProduct")
    public MasterDataProduct getMasterDataProduct() {
        return masterDataProduct;
    }

    @JsonProperty("masterDataProduct")
    public void setMasterDataProduct(MasterDataProduct masterDataProduct) {
        this.masterDataProduct = masterDataProduct;
    }

    @JsonProperty("definingAttributes")
    public List<DefiningAttribute> getDefiningAttributes() {
        return definingAttributes;
    }

    @JsonProperty("definingAttributes")
    public void setDefiningAttributes(List<DefiningAttribute> definingAttributes) {
        this.definingAttributes = definingAttributes;
    }

    @JsonProperty("descriptiveAttributes")
    public List<DescriptiveAttribute> getDescriptiveAttributes() {
        return descriptiveAttributes;
    }

    @JsonProperty("descriptiveAttributes")
    public void setDescriptiveAttributes(List<DescriptiveAttribute> descriptiveAttributes) {
        this.descriptiveAttributes = descriptiveAttributes;
    }

    @JsonProperty("productSpecialAttributes")
    public List<ProductSpecialAttribute> getProductSpecialAttributes() {
        return productSpecialAttributes;
    }

    @JsonProperty("productSpecialAttributes")
    public void setProductSpecialAttributes(List<ProductSpecialAttribute> productSpecialAttributes) {
        this.productSpecialAttributes = productSpecialAttributes;
    }

    @JsonProperty("itemCatalogs")
    public List<ItemCatalog> getItemCatalogs() {
        return itemCatalogs;
    }

    @JsonProperty("itemCatalogs")
    public void setItemCatalogs(List<ItemCatalog> itemCatalogs) {
        this.itemCatalogs = itemCatalogs;
    }

    @JsonProperty("salesCategorySequences")
    public Object getSalesCategorySequences() {
        return salesCategorySequences;
    }

    @JsonProperty("salesCategorySequences")
    public void setSalesCategorySequences(Object salesCategorySequences) {
        this.salesCategorySequences = salesCategorySequences;
    }

    @JsonProperty("installationRequired")
    public Boolean getInstallationRequired() {
        return installationRequired;
    }

    @JsonProperty("installationRequired")
    public void setInstallationRequired(Boolean installationRequired) {
        this.installationRequired = installationRequired;
    }

    @JsonProperty("off2OnChannelActive")
    public Boolean getOff2OnChannelActive() {
        return off2OnChannelActive;
    }

    @JsonProperty("off2OnChannelActive")
    public void setOff2OnChannelActive(Boolean off2OnChannelActive) {
        this.off2OnChannelActive = off2OnChannelActive;
    }

    @JsonProperty("productAttributes")
    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    @JsonProperty("productAttributes")
    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

    @JsonProperty("synchronized")
    public Boolean getSynchronized() {
        return _synchronized;
    }

    @JsonProperty("synchronized")
    public void setSynchronized(Boolean _synchronized) {
        this._synchronized = _synchronized;
    }

}
