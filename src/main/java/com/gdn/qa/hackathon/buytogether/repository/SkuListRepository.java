package com.gdn.qa.hackathon.buytogether.repository;

import com.gdn.qa.hackathon.buytogether.domain.SkuList;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SkuList entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SkuListRepository extends JpaRepository<SkuList, Long> {

    @Query("select skr from SkuList skr where skr.skuCode=:skuCode")
    SkuList findBySku(@Param("skuCode") String sku);

}
