package com.gdn.qa.hackathon.buytogether.web.rest;

import com.gdn.qa.hackathon.buytogether.domain.SkuBundle;
import com.gdn.qa.hackathon.buytogether.domain.SkuList;
import com.gdn.qa.hackathon.buytogether.repository.SkuBundleRepository;
import com.gdn.qa.hackathon.buytogether.repository.SkuListRepository;
import com.gdn.qa.hackathon.buytogether.service.xproduct.XproductServices;
import com.gdn.qa.hackathon.buytogether.web.rest.errors.BadRequestAlertException;
import com.gdn.qa.hackathon.buytogether.web.rest.model.SkuRecomendationResponse;
import com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct.Item;
import com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct.Price;
import com.gdn.qa.hackathon.buytogether.web.rest.model.xproduct.XproductResponse;
import com.gdn.qa.hackathon.buytogether.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing SkuList.
 */
@RestController
@RequestMapping("/api")
public class SkuListResource {

    private final Logger log = LoggerFactory.getLogger(SkuListResource.class);

    private static final String ENTITY_NAME = "skuList";

    private final SkuListRepository skuListRepository;

    private final XproductServices xproductServices;

    final
    SkuBundleRepository skuBundleRepository;

    @Autowired
    public SkuListResource(SkuListRepository skuListRepository, SkuBundleRepository skuBundleRepository, XproductServices xproductServices) {
        this.skuListRepository = skuListRepository;
        this.skuBundleRepository = skuBundleRepository;
        this.xproductServices = xproductServices;
    }

    /**
     * POST  /sku-lists : Create a new skuList.
     *
     * @param skuList the skuList to create
     * @return the ResponseEntity with status 201 (Created) and with body the new skuList, or with status 400 (Bad Request) if the skuList has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sku-lists")
    public ResponseEntity<SkuList> createSkuList(@Valid @RequestBody SkuList skuList) throws URISyntaxException {
        log.debug("REST request to save SkuList : {}", skuList);
        if (skuList.getId() != null) {
            throw new BadRequestAlertException("A new skuList cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SkuList result = skuListRepository.save(skuList);
        return ResponseEntity.created(new URI("/api/sku-lists/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sku-lists : Updates an existing skuList.
     *
     * @param skuList the skuList to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated skuList,
     * or with status 400 (Bad Request) if the skuList is not valid,
     * or with status 500 (Internal Server Error) if the skuList couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sku-lists")
    public ResponseEntity<SkuList> updateSkuList(@Valid @RequestBody SkuList skuList) throws URISyntaxException {
        log.debug("REST request to update SkuList : {}", skuList);
        if (skuList.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SkuList result = skuListRepository.save(skuList);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, skuList.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sku-lists : get all the skuLists.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of skuLists in body
     */
    @GetMapping("/sku-lists")
    public List<SkuList> getAllSkuLists() {
        log.debug("REST request to get all SkuLists");
        List<SkuList> skuLists = skuListRepository.findAll();
        skuLists.stream().forEach(skuList -> {
            skuList.setSkuBundles(skuBundleRepository.findBySkuList(skuList.getId()));
        });
        return skuLists;
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

    /**
     * GET  /sku-lists/:id : get the "id" skuList.
     *
     * @param id the id of the skuList to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the skuList, or with status 404 (Not Found)
     */
    @GetMapping("/sku-lists/{id}")
    public ResponseEntity<SkuList> getSkuList(@PathVariable Long id) {
        log.debug("REST request to get SkuList : {}", id);
        Optional<SkuList> skuList = skuListRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(skuList);
    }

    /**
     * DELETE  /sku-lists/:id : delete the "id" skuList.
     *
     * @param id the id of the skuList to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sku-lists/{id}")
    public ResponseEntity<Void> deleteSkuList(@PathVariable Long id) {
        log.debug("REST request to delete SkuList : {}", id);
        skuListRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    private Item getLowestPrice(List<Item> items) {
        return items.stream().min(Comparator.comparing(item -> item.getPrice().get(0).getOfferPrice())).get();
    }
}
