package com.gdn.qa.hackathon.buytogether.service.xproduct;

import com.gdn.qa.hackathon.buytogether.config.ApplicationProperties;
import com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct.XproductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static com.gdn.qa.hackathon.buytogether.service.xproduct.Constant.GET_PRODUCT_AND_ITEM;
import static com.gdn.qa.hackathon.buytogether.service.xproduct.Constant.XPRODUCT_URL;

/**
 * User: argo.triwidodo
 * Date: 02-Mar-19
 * Time: 12:17
 */

@Component
public class XproductServices {


    private RestTemplate restTemplate;

    public XproductResponse getXproductDetailBySku(String skuCode) throws URISyntaxException {
        restTemplate = new RestTemplate();
        return restTemplate.getForObject(new URI(XPRODUCT_URL + GET_PRODUCT_AND_ITEM + "/?storeId=10001&channelId=1&clientId=web&requestId=1&showDeleted=true&productSku=" + skuCode + "&combineOthersBundlings=false"), XproductResponse.class);
    }

}
