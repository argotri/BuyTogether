package com.gdn.qa.hackathon.buytogether.repository;

import com.gdn.qa.hackathon.buytogether.domain.SkuBundle;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SkuBundle entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SkuBundleRepository extends JpaRepository<SkuBundle, Long> {

}
