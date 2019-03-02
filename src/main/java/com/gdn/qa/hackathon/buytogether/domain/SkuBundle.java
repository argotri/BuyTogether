package com.gdn.qa.hackathon.buytogether.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
    @Column(name = "parent_sku", nullable = false)
    private String parentSku;

    @Column(name = "score")
    private Float score;

    @Enumerated(EnumType.STRING)
    @Column(name = "source")
    private Source source;

    @OneToMany(mappedBy = "skuBundle")
    private Set<SkuList> parentSkus = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentSku() {
        return parentSku;
    }

    public SkuBundle parentSku(String parentSku) {
        this.parentSku = parentSku;
        return this;
    }

    public void setParentSku(String parentSku) {
        this.parentSku = parentSku;
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

    public Set<SkuList> getParentSkus() {
        return parentSkus;
    }

    public SkuBundle parentSkus(Set<SkuList> skuLists) {
        this.parentSkus = skuLists;
        return this;
    }

    public SkuBundle addParentSku(SkuList skuList) {
        this.parentSkus.add(skuList);
        skuList.setSkuBundle(this);
        return this;
    }

    public SkuBundle removeParentSku(SkuList skuList) {
        this.parentSkus.remove(skuList);
        skuList.setSkuBundle(null);
        return this;
    }

    public void setParentSkus(Set<SkuList> skuLists) {
        this.parentSkus = skuLists;
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
            ", parentSku='" + getParentSku() + "'" +
            ", score=" + getScore() +
            ", source='" + getSource() + "'" +
            "}";
    }
}
