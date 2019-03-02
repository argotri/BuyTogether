
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "offerPrice",
    "listPrice",
    "channel",
    "listOfDiscountPrices",
    "lastUpdatedBy",
    "lastUpdatedDate"
})
public class Price {

    @JsonProperty("currency")
    private Object currency;
    @JsonProperty("offerPrice")
    private Long offerPrice;
    @JsonProperty("listPrice")
    private Long listPrice;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("listOfDiscountPrices")
    private List<Object> listOfDiscountPrices = null;
    @JsonProperty("lastUpdatedBy")
    private String lastUpdatedBy;
    @JsonProperty("lastUpdatedDate")
    private Long lastUpdatedDate;

    @JsonProperty("currency")
    public Object getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(Object currency) {
        this.currency = currency;
    }

    @JsonProperty("offerPrice")
    public Long getOfferPrice() {
        return offerPrice;
    }

    @JsonProperty("offerPrice")
    public void setOfferPrice(Long offerPrice) {
        this.offerPrice = offerPrice;
    }

    @JsonProperty("listPrice")
    public Long getListPrice() {
        return listPrice;
    }

    @JsonProperty("listPrice")
    public void setListPrice(Long listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @JsonProperty("listOfDiscountPrices")
    public List<Object> getListOfDiscountPrices() {
        return listOfDiscountPrices;
    }

    @JsonProperty("listOfDiscountPrices")
    public void setListOfDiscountPrices(List<Object> listOfDiscountPrices) {
        this.listOfDiscountPrices = listOfDiscountPrices;
    }

    @JsonProperty("lastUpdatedBy")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @JsonProperty("lastUpdatedBy")
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @JsonProperty("lastUpdatedDate")
    public Long getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @JsonProperty("lastUpdatedDate")
    public void setLastUpdatedDate(Long lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

}
