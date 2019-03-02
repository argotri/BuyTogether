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
}
