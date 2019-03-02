package com.gdn.qa.hackathon.buytogether.repository;

import com.gdn.qa.hackathon.buytogether.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
