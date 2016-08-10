/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.web.DAO.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dell
 */
@Embeddable
public class ProductMasterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "product_id")
    private String productId;
    @Basic(optional = false)
    @Column(name = "product_master_id")
    private int productMasterId;

    public ProductMasterPK() {
    }

    public ProductMasterPK(String productId, int productMasterId) {
        this.productId = productId;
        this.productMasterId = productMasterId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductMasterId() {
        return productMasterId;
    }

    public void setProductMasterId(int productMasterId) {
        this.productMasterId = productMasterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        hash += (int) productMasterId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductMasterPK)) {
            return false;
        }
        ProductMasterPK other = (ProductMasterPK) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        if (this.productMasterId != other.productMasterId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.order.web.DAO.entity.ProductMasterPK[ productId=" + productId + ", productMasterId=" + productMasterId + " ]";
    }
    
}
