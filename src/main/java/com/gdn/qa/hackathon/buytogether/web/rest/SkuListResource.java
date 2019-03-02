package com.gdn.qa.hackathon.buytogether.web.rest;
import com.gdn.qa.hackathon.buytogether.domain.SkuList;
import com.gdn.qa.hackathon.buytogether.repository.SkuListRepository;
import com.gdn.qa.hackathon.buytogether.web.rest.errors.BadRequestAlertException;
import com.gdn.qa.hackathon.buytogether.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing SkuList.
 */
@RestController
@RequestMapping("/api")
public class SkuListResource {

    private final Logger log = LoggerFactory.getLogger(SkuListResource.class);

    private static final String ENTITY_NAME = "skuList";

    private final SkuListRepository skuListRepository;

    public SkuListResource(SkuListRepository skuListRepository) {
        this.skuListRepository = skuListRepository;
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
        return skuListRepository.findAll();
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
}
