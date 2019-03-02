package com.gdn.qa.hackathon.buytogether.web.rest;
import com.gdn.qa.hackathon.buytogether.domain.SkuBundle;
import com.gdn.qa.hackathon.buytogether.repository.SkuBundleRepository;
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
 * REST controller for managing SkuBundle.
 */
@RestController
@RequestMapping("/api")
public class SkuBundleResource {

    private final Logger log = LoggerFactory.getLogger(SkuBundleResource.class);

    private static final String ENTITY_NAME = "skuBundle";

    private final SkuBundleRepository skuBundleRepository;

    public SkuBundleResource(SkuBundleRepository skuBundleRepository) {
        this.skuBundleRepository = skuBundleRepository;
    }

    /**
     * POST  /sku-bundles : Create a new skuBundle.
     *
     * @param skuBundle the skuBundle to create
     * @return the ResponseEntity with status 201 (Created) and with body the new skuBundle, or with status 400 (Bad Request) if the skuBundle has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sku-bundles")
    public ResponseEntity<SkuBundle> createSkuBundle(@Valid @RequestBody SkuBundle skuBundle) throws URISyntaxException {
        log.debug("REST request to save SkuBundle : {}", skuBundle);
        if (skuBundle.getId() != null) {
            throw new BadRequestAlertException("A new skuBundle cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SkuBundle result = skuBundleRepository.save(skuBundle);
        return ResponseEntity.created(new URI("/api/sku-bundles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sku-bundles : Updates an existing skuBundle.
     *
     * @param skuBundle the skuBundle to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated skuBundle,
     * or with status 400 (Bad Request) if the skuBundle is not valid,
     * or with status 500 (Internal Server Error) if the skuBundle couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sku-bundles")
    public ResponseEntity<SkuBundle> updateSkuBundle(@Valid @RequestBody SkuBundle skuBundle) throws URISyntaxException {
        log.debug("REST request to update SkuBundle : {}", skuBundle);
        if (skuBundle.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SkuBundle result = skuBundleRepository.save(skuBundle);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, skuBundle.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sku-bundles : get all the skuBundles.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of skuBundles in body
     */
    @GetMapping("/sku-bundles")
    public List<SkuBundle> getAllSkuBundles() {
        log.debug("REST request to get all SkuBundles");
        return skuBundleRepository.findAll();
    }

    /**
     * GET  /sku-bundles/:id : get the "id" skuBundle.
     *
     * @param id the id of the skuBundle to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the skuBundle, or with status 404 (Not Found)
     */
    @GetMapping("/sku-bundles/{id}")
    public ResponseEntity<SkuBundle> getSkuBundle(@PathVariable Long id) {
        log.debug("REST request to get SkuBundle : {}", id);
        Optional<SkuBundle> skuBundle = skuBundleRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(skuBundle);
    }

    /**
     * DELETE  /sku-bundles/:id : delete the "id" skuBundle.
     *
     * @param id the id of the skuBundle to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sku-bundles/{id}")
    public ResponseEntity<Void> deleteSkuBundle(@PathVariable Long id) {
        log.debug("REST request to delete SkuBundle : {}", id);
        skuBundleRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
