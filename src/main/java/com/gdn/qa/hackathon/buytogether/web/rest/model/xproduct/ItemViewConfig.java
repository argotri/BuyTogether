
package com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channel",
    "itemDiscoverableSchedules",
    "itemBuyableSchedules",
    "discoverable",
    "buyable"
})
public class ItemViewConfig {

    @JsonProperty("channel")
    private String channel;
    @JsonProperty("itemDiscoverableSchedules")
    private Object itemDiscoverableSchedules;
    @JsonProperty("itemBuyableSchedules")
    private Object itemBuyableSchedules;
    @JsonProperty("discoverable")
    private Boolean discoverable;
    @JsonProperty("buyable")
    private Boolean buyable;

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @JsonProperty("itemDiscoverableSchedules")
    public Object getItemDiscoverableSchedules() {
        return itemDiscoverableSchedules;
    }

    @JsonProperty("itemDiscoverableSchedules")
    public void setItemDiscoverableSchedules(Object itemDiscoverableSchedules) {
        this.itemDiscoverableSchedules = itemDiscoverableSchedules;
    }

    @JsonProperty("itemBuyableSchedules")
    public Object getItemBuyableSchedules() {
        return itemBuyableSchedules;
    }

    @JsonProperty("itemBuyableSchedules")
    public void setItemBuyableSchedules(Object itemBuyableSchedules) {
        this.itemBuyableSchedules = itemBuyableSchedules;
    }

    @JsonProperty("discoverable")
    public Boolean getDiscoverable() {
        return discoverable;
    }

    @JsonProperty("discoverable")
    public void setDiscoverable(Boolean discoverable) {
        this.discoverable = discoverable;
    }

    @JsonProperty("buyable")
    public Boolean getBuyable() {
        return buyable;
    }

    @JsonProperty("buyable")
    public void setBuyable(Boolean buyable) {
        this.buyable = buyable;
    }

}
