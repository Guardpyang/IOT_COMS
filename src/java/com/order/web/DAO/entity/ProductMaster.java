/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.web.DAO.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "product_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductMaster.findAll", query = "SELECT p FROM ProductMaster p"),
    @NamedQuery(name = "ProductMaster.findByProductId", query = "SELECT p FROM ProductMaster p WHERE p.productMasterPK.productId = :productId"),
    @NamedQuery(name = "ProductMaster.findByProductName", query = "SELECT p FROM ProductMaster p WHERE p.productName = :productName"),
    @NamedQuery(name = "ProductMaster.findByProductSpec", query = "SELECT p FROM ProductMaster p WHERE p.productSpec = :productSpec"),
    @NamedQuery(name = "ProductMaster.findByProductPrice", query = "SELECT p FROM ProductMaster p WHERE p.productPrice = :productPrice"),
    @NamedQuery(name = "ProductMaster.findByProductMasterId", query = "SELECT p FROM ProductMaster p WHERE p.productMasterPK.productMasterId = :productMasterId")})
public class ProductMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductMasterPK productMasterPK;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @Column(name = "product_spec")
    private String productSpec;
    @Basic(optional = false)
    @Column(name = "product_price")
    private double productPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productMasterId")
    private Collection<CustomerPrice> customerPriceCollection;
    @OneToMany(mappedBy = "productId")
    private Collection<OrderDetail> orderDetailCollection;

    public ProductMaster() {
    }

    public ProductMaster(ProductMasterPK productMasterPK) {
        this.productMasterPK = productMasterPK;
    }

    public ProductMaster(ProductMasterPK productMasterPK, String productName, String productSpec, double productPrice) {
        this.productMasterPK = productMasterPK;
        this.productName = productName;
        this.productSpec = productSpec;
        this.productPrice = productPrice;
    }

    public ProductMaster(String productId, int productMasterId) {
        this.productMasterPK = new ProductMasterPK(productId, productMasterId);
    }

    public ProductMasterPK getProductMasterPK() {
        return productMasterPK;
    }

    public void setProductMasterPK(ProductMasterPK productMasterPK) {
        this.productMasterPK = productMasterPK;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @XmlTransient
    public Collection<CustomerPrice> getCustomerPriceCollection() {
        return customerPriceCollection;
    }

    public void setCustomerPriceCollection(Collection<CustomerPrice> customerPriceCollection) {
        this.customerPriceCollection = customerPriceCollection;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productMasterPK != null ? productMasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductMaster)) {
            return false;
        }
        ProductMaster other = (ProductMaster) object;
        if ((this.productMasterPK == null && other.productMasterPK != null) || (this.productMasterPK != null && !this.productMasterPK.equals(other.productMasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.order.web.DAO.entity.ProductMaster[ productMasterPK=" + productMasterPK + " ]";
    }
    
}
