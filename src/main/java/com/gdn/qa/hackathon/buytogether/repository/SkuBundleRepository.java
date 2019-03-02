package com.gdn.qa.hackathon.buytogether.repository;

import com.gdn.qa.hackathon.buytogether.domain.SkuBundle;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


/**
 * Spring Data  repository for the SkuBundle entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SkuBundleRepository extends JpaRepository<SkuBundle, Long> {
    @Query("select sbr from SkuBundle sbr where sbr.skuList.id=:skulist ")
    Set<SkuBundle> findBySkuList(@Param("skulist") Long skuList);
}
