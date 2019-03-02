package com.gdn.qa.hackathon.buytogether.web.rest.model;

import lombok.Builder;
import lombok.Data;

/**
 * User: argo.triwidodo
 * Date: 02-Mar-19
 * Time: 15:58
 */

@Builder
@Data
public class SkuRecomendationResponse {
    private String productName;
    private Long price;
    private String image;
    private String productSku;

    public SkuRecomendationResponse() {
    }

    public SkuRecomendationResponse(String productName, Long price, String image, String productSku) {
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.productSku = productSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }
}
