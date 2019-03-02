package com.gdn.qa.hackathon.buytogether.web.rest;

import com.gdn.qa.hackathon.buytogether.BuyTogetherApp;

import com.gdn.qa.hackathon.buytogether.domain.SkuBundle;
import com.gdn.qa.hackathon.buytogether.repository.SkuBundleRepository;
import com.gdn.qa.hackathon.buytogether.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;


import static com.gdn.qa.hackathon.buytogether.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.gdn.qa.hackathon.buytogether.domain.enumeration.Source;
/**
 * Test class for the SkuBundleResource REST controller.
 *
 * @see SkuBundleResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuyTogetherApp.class)
public class SkuBundleResourceIntTest {

    private static final String DEFAULT_PARENT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_SKU = "BBBBBBBBBB";

    private static final Float DEFAULT_SCORE = 1F;
    private static final Float UPDATED_SCORE = 2F;

    private static final Source DEFAULT_SOURCE = Source.MANUAL_INPUT;
    private static final Source UPDATED_SOURCE = Source.SYSTEM_INPUT;

    @Autowired
    private SkuBundleRepository skuBundleRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restSkuBundleMockMvc;

    private SkuBundle skuBundle;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SkuBundleResource skuBundleResource = new SkuBundleResource(skuBundleRepository);
        this.restSkuBundleMockMvc = MockMvcBuilders.standaloneSetup(skuBundleResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SkuBundle createEntity(EntityManager em) {
        SkuBundle skuBundle = new SkuBundle()
            .parentSku(DEFAULT_PARENT_SKU)
            .score(DEFAULT_SCORE)
            .source(DEFAULT_SOURCE);
        return skuBundle;
    }

    @Before
    public void initTest() {
        skuBundle = createEntity(em);
    }

    @Test
    @Transactional
    public void createSkuBundle() throws Exception {
        int databaseSizeBeforeCreate = skuBundleRepository.findAll().size();

        // Create the SkuBundle
        restSkuBundleMockMvc.perform(post("/api/sku-bundles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(skuBundle)))
            .andExpect(status().isCreated());

        // Validate the SkuBundle in the database
        List<SkuBundle> skuBundleList = skuBundleRepository.findAll();
        assertThat(skuBundleList).hasSize(databaseSizeBeforeCreate + 1);
        SkuBundle testSkuBundle = skuBundleList.get(skuBundleList.size() - 1);
        assertThat(testSkuBundle.getParentSku()).isEqualTo(DEFAULT_PARENT_SKU);
        assertThat(testSkuBundle.getScore()).isEqualTo(DEFAULT_SCORE);
        assertThat(testSkuBundle.getSource()).isEqualTo(DEFAULT_SOURCE);
    }

    @Test
    @Transactional
    public void createSkuBundleWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = skuBundleRepository.findAll().size();

        // Create the SkuBundle with an existing ID
        skuBundle.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSkuBundleMockMvc.perform(post("/api/sku-bundles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(skuBundle)))
            .andExpect(status().isBadRequest());

        // Validate the SkuBundle in the database
        List<SkuBundle> skuBundleList = skuBundleRepository.findAll();
        assertThat(skuBundleList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkParentSkuIsRequired() throws Exception {
        int databaseSizeBeforeTest = skuBundleRepository.findAll().size();
        // set the field null
        skuBundle.setParentSku(null);

        // Create the SkuBundle, which fails.

        restSkuBundleMockMvc.perform(post("/api/sku-bundles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(skuBundle)))
            .andExpect(status().isBadRequest());

        List<SkuBundle> skuBundleList = skuBundleRepository.findAll();
        assertThat(skuBundleList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSkuBundles() throws Exception {
        // Initialize the database
        skuBundleRepository.saveAndFlush(skuBundle);

        // Get all the skuBundleList
        restSkuBundleMockMvc.perform(get("/api/sku-bundles?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(skuBundle.getId().intValue())))
            .andExpect(jsonPath("$.[*].parentSku").value(hasItem(DEFAULT_PARENT_SKU.toString())))
            .andExpect(jsonPath("$.[*].score").value(hasItem(DEFAULT_SCORE.doubleValue())))
            .andExpect(jsonPath("$.[*].source").value(hasItem(DEFAULT_SOURCE.toString())));
    }
    
    @Test
    @Transactional
    public void getSkuBundle() throws Exception {
        // Initialize the database
        skuBundleRepository.saveAndFlush(skuBundle);

        // Get the skuBundle
        restSkuBundleMockMvc.perform(get("/api/sku-bundles/{id}", skuBundle.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(skuBundle.getId().intValue()))
            .andExpect(jsonPath("$.parentSku").value(DEFAULT_PARENT_SKU.toString()))
            .andExpect(jsonPath("$.score").value(DEFAULT_SCORE.doubleValue()))
            .andExpect(jsonPath("$.source").value(DEFAULT_SOURCE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingSkuBundle() throws Exception {
        // Get the skuBundle
        restSkuBundleMockMvc.perform(get("/api/sku-bundles/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSkuBundle() throws Exception {
        // Initialize the database
        skuBundleRepository.saveAndFlush(skuBundle);

        int databaseSizeBeforeUpdate = skuBundleRepository.findAll().size();

        // Update the skuBundle
        SkuBundle updatedSkuBundle = skuBundleRepository.findById(skuBundle.getId()).get();
        // Disconnect from session so that the updates on updatedSkuBundle are not directly saved in db
        em.detach(updatedSkuBundle);
        updatedSkuBundle
            .parentSku(UPDATED_PARENT_SKU)
            .score(UPDATED_SCORE)
            .source(UPDATED_SOURCE);

        restSkuBundleMockMvc.perform(put("/api/sku-bundles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSkuBundle)))
            .andExpect(status().isOk());

        // Validate the SkuBundle in the database
        List<SkuBundle> skuBundleList = skuBundleRepository.findAll();
        assertThat(skuBundleList).hasSize(databaseSizeBeforeUpdate);
        SkuBundle testSkuBundle = skuBundleList.get(skuBundleList.size() - 1);
        assertThat(testSkuBundle.getParentSku()).isEqualTo(UPDATED_PARENT_SKU);
        assertThat(testSkuBundle.getScore()).isEqualTo(UPDATED_SCORE);
        assertThat(testSkuBundle.getSource()).isEqualTo(UPDATED_SOURCE);
    }

    @Test
    @Transactional
    public void updateNonExistingSkuBundle() throws Exception {
        int databaseSizeBeforeUpdate = skuBundleRepository.findAll().size();

        // Create the SkuBundle

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSkuBundleMockMvc.perform(put("/api/sku-bundles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(skuBundle)))
            .andExpect(status().isBadRequest());

        // Validate the SkuBundle in the database
        List<SkuBundle> skuBundleList = skuBundleRepository.findAll();
        assertThat(skuBundleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSkuBundle() throws Exception {
        // Initialize the database
        skuBundleRepository.saveAndFlush(skuBundle);

        int databaseSizeBeforeDelete = skuBundleRepository.findAll().size();

        // Delete the skuBundle
        restSkuBundleMockMvc.perform(delete("/api/sku-bundles/{id}", skuBundle.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<SkuBundle> skuBundleList = skuBundleRepository.findAll();
        assertThat(skuBundleList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SkuBundle.class);
        SkuBundle skuBundle1 = new SkuBundle();
        skuBundle1.setId(1L);
        SkuBundle skuBundle2 = new SkuBundle();
        skuBundle2.setId(skuBundle1.getId());
        assertThat(skuBundle1).isEqualTo(skuBundle2);
        skuBundle2.setId(2L);
        assertThat(skuBundle1).isNotEqualTo(skuBundle2);
        skuBundle1.setId(null);
        assertThat(skuBundle1).isNotEqualTo(skuBundle2);
    }
}
