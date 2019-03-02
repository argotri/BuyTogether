package com.gdn.qa.hackathon.buytogether.web.rest;

import com.gdn.qa.hackathon.buytogether.domain.SkuBundle;
import com.gdn.qa.hackathon.buytogether.domain.SkuList;
import com.gdn.qa.hackathon.buytogether.repository.SkuBundleRepository;
import com.gdn.qa.hackathon.buytogether.repository.SkuListRepository;
import com.gdn.qa.hackathon.buytogether.service.xproduct.XproductServices;
import com.gdn.qa.hackathon.buytogether.web.rest.model.SkuRecomendationResponse;
import com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct.Item;
import com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct.Price;
import com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct.XproductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * User: argo.triwidodo
 * Date: 02-Mar-19
 * Time: 18:07
 */

@RestController
@RequestMapping("/recomendation")
public class ProductRecomendation {

    private final SkuListRepository skuListRepository;

    private final XproductServices xproductServices;

    private final SkuBundleRepository skuBundleRepository;

    @Autowired
    public ProductRecomendation(SkuListRepository skuListRepository, XproductServices xproductServices, SkuBundleRepository skuBundleRepository) {
        this.skuListRepository = skuListRepository;
        this.xproductServices = xproductServices;
        this.skuBundleRepository = skuBundleRepository;
    }

    @RequestMapping(name = "Get SKU Recomendation By Score", path = "/sku-recomendation/{sku}", method = RequestMethod.GET)
    public List<SkuRecomendationResponse> getRecomendationBySku(@PathVariable String sku) throws URISyntaxException {
        List<SkuRecomendationResponse> skuRecomendationResponses = new ArrayList<>();
        SkuList skuLists = skuListRepository.findBySku(sku);
        //xproductServices.getXproductDetailBySku(sku);
        Set<SkuBundle> recomendationList = skuBundleRepository.findBySkuList(skuLists.getId());
        recomendationList.forEach(skuBundle -> {
            try {
                XproductResponse product = xproductServices.getXproductDetailBySku(skuBundle.getSku());
                skuRecomendationResponses
                    .add(SkuRecomendationResponse.builder()
                        .image(product.getValue().getProduct().getMasterDataProduct().getMasterDataProductImages().stream().filter(masterDataProductImage -> masterDataProductImage.getMainImage()).findAny().get().getLocationPath())
                        .price(getLowestPrice(product.getValue().getItems()).getPrice().stream().min(Comparator.comparing(Price::getOfferPrice)).get().getOfferPrice())
                        .productName(product.getValue().getProduct().getMasterDataProduct().getProductName())
                        .productSku(getLowestPrice(product.getValue().getItems()).getProductSku())
                        .build());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        return skuRecomendationResponses;
    }

    private Item getLowestPrice(List<Item> items) {
        return items.stream().min(Comparator.comparing(item -> item.getPrice().get(0).getOfferPrice())).get();
    }
}
