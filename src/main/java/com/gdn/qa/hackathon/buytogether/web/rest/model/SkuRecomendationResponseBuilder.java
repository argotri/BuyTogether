package com.gdn.qa.hackathon.buytogether.web.rest.model;

public class SkuRecomendationResponseBuilder {
    private String productName;
    private Long price;
    private String image;
    private String productSku;

    public SkuRecomendationResponseBuilder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public SkuRecomendationResponseBuilder setPrice(Long price) {
        this.price = price;
        return this;
    }

    public SkuRecomendationResponseBuilder setImage(String image) {
        this.image = image;
        return this;
    }

    public SkuRecomendationResponseBuilder setProductSku(String productSku) {
        this.productSku = productSku;
        return this;
    }

    public SkuRecomendationResponse createSkuRecomendationResponse() {
        return new SkuRecomendationResponse(productName, price, image, productSku);
    }
}
