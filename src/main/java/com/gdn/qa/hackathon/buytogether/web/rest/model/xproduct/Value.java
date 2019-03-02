
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
    "product",
    "items"
})
public class Value {

    @JsonProperty("id")
    private Object id;
    @JsonProperty("storeId")
    private Object storeId;
    @JsonProperty("createdDate")
    private Object createdDate;
    @JsonProperty("createdBy")
    private Object createdBy;
    @JsonProperty("updatedDate")
    private Object updatedDate;
    @JsonProperty("updatedBy")
    private Object updatedBy;
    @JsonProperty("version")
    private Object version;
    @JsonProperty("product")
    private Product product;
    @JsonProperty("items")
    private List<Item> items = null;

    @JsonProperty("id")
    public Object getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Object id) {
        this.id = id;
    }

    @JsonProperty("storeId")
    public Object getStoreId() {
        return storeId;
    }

    @JsonProperty("storeId")
    public void setStoreId(Object storeId) {
        this.storeId = storeId;
    }

    @JsonProperty("createdDate")
    public Object getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(Object createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("createdBy")
    public Object getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("updatedDate")
    public Object getUpdatedDate() {
        return updatedDate;
    }

    @JsonProperty("updatedDate")
    public void setUpdatedDate(Object updatedDate) {
        this.updatedDate = updatedDate;
    }

    @JsonProperty("updatedBy")
    public Object getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty("updatedBy")
    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonProperty("version")
    public Object getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Object version) {
        this.version = version;
    }

    @JsonProperty("product")
    public Product getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

}
