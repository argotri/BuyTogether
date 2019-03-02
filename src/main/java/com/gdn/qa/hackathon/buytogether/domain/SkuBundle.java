package com.gdn.qa.hackathon.buytogether.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

import com.gdn.qa.hackathon.buytogether.domain.enumeration.Source;

/**
 * A SkuBundle.
 */
@Entity
@Table(name = "sku_bundle")
public class SkuBundle implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "score")
    private Float score;

    @Enumerated(EnumType.STRING)
    @Column(name = "source")
    private Source source;

    @ManyToOne
    @JsonIgnoreProperties("skuBundles")
    private SkuList skuList;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public SkuBundle sku(String sku) {
        this.sku = sku;
        return this;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Float getScore() {
        return score;
    }

    public SkuBundle score(Float score) {
        this.score = score;
        return this;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Source getSource() {
        return source;
    }

    public SkuBundle source(Source source) {
        this.source = source;
        return this;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public SkuList getSkuList() {
        return skuList;
    }

    public SkuBundle skuList(SkuList skuList) {
        this.skuList = skuList;
        return this;
    }

    public void setSkuList(SkuList skuList) {
        this.skuList = skuList;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SkuBundle skuBundle = (SkuBundle) o;
        if (skuBundle.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), skuBundle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SkuBundle{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            ", score=" + getScore() +
            ", source='" + getSource() + "'" +
            "}";
    }
}
