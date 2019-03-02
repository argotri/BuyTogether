package com.gdn.qa.hackathon.buytogether.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A SkuList.
 */
@Entity
@Table(name = "sku_list")
public class SkuList implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "sku_code", nullable = false)
    private String skuCode;

    @Column(name = "added_by")
    private String addedBy;

    @OneToMany(mappedBy = "skuList")
    private Set<SkuBundle> skuBundles = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public SkuList skuCode(String skuCode) {
        this.skuCode = skuCode;
        return this;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public SkuList addedBy(String addedBy) {
        this.addedBy = addedBy;
        return this;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Set<SkuBundle> getSkuBundles() {
        return skuBundles;
    }

    public SkuList skuBundles(Set<SkuBundle> skuBundles) {
        this.skuBundles = skuBundles;
        return this;
    }

    public SkuList addSkuBundle(SkuBundle skuBundle) {
        this.skuBundles.add(skuBundle);
        skuBundle.setSkuList(this);
        return this;
    }

    public SkuList removeSkuBundle(SkuBundle skuBundle) {
        this.skuBundles.remove(skuBundle);
        skuBundle.setSkuList(null);
        return this;
    }

    public void setSkuBundles(Set<SkuBundle> skuBundles) {
        this.skuBundles = skuBundles;
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
        SkuList skuList = (SkuList) o;
        if (skuList.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), skuList.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SkuList{" +
            "id=" + getId() +
            ", skuCode='" + getSkuCode() + "'" +
            ", addedBy='" + getAddedBy() + "'" +
            "}";
    }
}
