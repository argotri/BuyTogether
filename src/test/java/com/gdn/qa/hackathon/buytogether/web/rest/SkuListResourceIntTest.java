package com.gdn.qa.hackathon.buytogether.web.rest;

import com.gdn.qa.hackathon.buytogether.BuyTogetherApp;

import com.gdn.qa.hackathon.buytogether.domain.SkuList;
import com.gdn.qa.hackathon.buytogether.repository.SkuListRepository;
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

/**
 * Test class for the SkuListResource REST controller.
 *
 * @see SkuListResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuyTogetherApp.class)
public class SkuListResourceIntTest {

    private static final String DEFAULT_SKU_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SKU_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ADDED_BY = "AAAAAAAAAA";
    private static final String UPDATED_ADDED_BY = "BBBBBBBBBB";

    @Autowired
    private SkuListRepository skuListRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

//    @Autowired
//    private Validator validator;

    private MockMvc restSkuListMockMvc;

    private SkuList skuList;

    @Before
    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        final SkuListResource skuListResource = new SkuListResource(skuListRepository);
//        this.restSkuListMockMvc = MockMvcBuilders.standaloneSetup(skuListResource)
//            .setCustomArgumentResolvers(pageableArgumentResolver)
//            .setControllerAdvice(exceptionTranslator)
//            .setConversionService(createFormattingConversionService())
//            .setMessageConverters(jacksonMessageConverter)
//            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SkuList createEntity(EntityManager em) {
        SkuList skuList = new SkuList()
            .skuCode(DEFAULT_SKU_CODE)
            .addedBy(DEFAULT_ADDED_BY);
        return skuList;
    }

    @Before
    public void initTest() {
        skuList = createEntity(em);
    }

    @Test
    @Transactional
    public void createSkuList() throws Exception {
        int databaseSizeBeforeCreate = skuListRepository.findAll().size();

        // Create the SkuList
        restSkuListMockMvc.perform(post("/api/sku-lists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(skuList)))
            .andExpect(status().isCreated());

        // Validate the SkuList in the database
        List<SkuList> skuListList = skuListRepository.findAll();
        assertThat(skuListList).hasSize(databaseSizeBeforeCreate + 1);
        SkuList testSkuList = skuListList.get(skuListList.size() - 1);
        assertThat(testSkuList.getSkuCode()).isEqualTo(DEFAULT_SKU_CODE);
        assertThat(testSkuList.getAddedBy()).isEqualTo(DEFAULT_ADDED_BY);
    }

    @Test
    @Transactional
    public void createSkuListWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = skuListRepository.findAll().size();

        // Create the SkuList with an existing ID
        skuList.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSkuListMockMvc.perform(post("/api/sku-lists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(skuList)))
            .andExpect(status().isBadRequest());

        // Validate the SkuList in the database
        List<SkuList> skuListList = skuListRepository.findAll();
        assertThat(skuListList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkSkuCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skuListRepository.findAll().size();
        // set the field null
        skuList.setSkuCode(null);

        // Create the SkuList, which fails.

        restSkuListMockMvc.perform(post("/api/sku-lists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(skuList)))
            .andExpect(status().isBadRequest());

        List<SkuList> skuListList = skuListRepository.findAll();
        assertThat(skuListList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSkuLists() throws Exception {
        // Initialize the database
        skuListRepository.saveAndFlush(skuList);

        // Get all the skuListList
        restSkuListMockMvc.perform(get("/api/sku-lists?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(skuList.getId().intValue())))
            .andExpect(jsonPath("$.[*].skuCode").value(hasItem(DEFAULT_SKU_CODE.toString())))
            .andExpect(jsonPath("$.[*].addedBy").value(hasItem(DEFAULT_ADDED_BY.toString())));
    }
    
    @Test
    @Transactional
    public void getSkuList() throws Exception {
        // Initialize the database
        skuListRepository.saveAndFlush(skuList);

        // Get the skuList
        restSkuListMockMvc.perform(get("/api/sku-lists/{id}", skuList.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(skuList.getId().intValue()))
            .andExpect(jsonPath("$.skuCode").value(DEFAULT_SKU_CODE.toString()))
            .andExpect(jsonPath("$.addedBy").value(DEFAULT_ADDED_BY.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingSkuList() throws Exception {
        // Get the skuList
        restSkuListMockMvc.perform(get("/api/sku-lists/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSkuList() throws Exception {
        // Initialize the database
        skuListRepository.saveAndFlush(skuList);

        int databaseSizeBeforeUpdate = skuListRepository.findAll().size();

        // Update the skuList
        SkuList updatedSkuList = skuListRepository.findById(skuList.getId()).get();
        // Disconnect from session so that the updates on updatedSkuList are not directly saved in db
        em.detach(updatedSkuList);
        updatedSkuList
            .skuCode(UPDATED_SKU_CODE)
            .addedBy(UPDATED_ADDED_BY);

        restSkuListMockMvc.perform(put("/api/sku-lists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSkuList)))
            .andExpect(status().isOk());

        // Validate the SkuList in the database
        List<SkuList> skuListList = skuListRepository.findAll();
        assertThat(skuListList).hasSize(databaseSizeBeforeUpdate);
        SkuList testSkuList = skuListList.get(skuListList.size() - 1);
        assertThat(testSkuList.getSkuCode()).isEqualTo(UPDATED_SKU_CODE);
        assertThat(testSkuList.getAddedBy()).isEqualTo(UPDATED_ADDED_BY);
    }

    @Test
    @Transactional
    public void updateNonExistingSkuList() throws Exception {
        int databaseSizeBeforeUpdate = skuListRepository.findAll().size();

        // Create the SkuList

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSkuListMockMvc.perform(put("/api/sku-lists")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(skuList)))
            .andExpect(status().isBadRequest());

        // Validate the SkuList in the database
        List<SkuList> skuListList = skuListRepository.findAll();
        assertThat(skuListList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSkuList() throws Exception {
        // Initialize the database
        skuListRepository.saveAndFlush(skuList);

        int databaseSizeBeforeDelete = skuListRepository.findAll().size();

        // Delete the skuList
        restSkuListMockMvc.perform(delete("/api/sku-lists/{id}", skuList.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<SkuList> skuListList = skuListRepository.findAll();
        assertThat(skuListList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SkuList.class);
        SkuList skuList1 = new SkuList();
        skuList1.setId(1L);
        SkuList skuList2 = new SkuList();
        skuList2.setId(skuList1.getId());
        assertThat(skuList1).isEqualTo(skuList2);
        skuList2.setId(2L);
        assertThat(skuList1).isNotEqualTo(skuList2);
        skuList1.setId(null);
        assertThat(skuList1).isNotEqualTo(skuList2);
    }
}
