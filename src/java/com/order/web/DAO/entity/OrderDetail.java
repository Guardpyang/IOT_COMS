/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.web.DAO.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByOrderNumber", query = "SELECT o FROM OrderDetail o WHERE o.orderNumber = :orderNumber"),
    @NamedQuery(name = "OrderDetail.findByOrderPrice", query = "SELECT o FROM OrderDetail o WHERE o.orderPrice = :orderPrice"),
    @NamedQuery(name = "OrderDetail.findByOrderDetailId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailId = :orderDetailId")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "order_number")
    private int orderNumber;
    @Basic(optional = false)
    @Column(name = "order_price")
    private float orderPrice;
    @Id
    @Basic(optional = false)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;
    @JoinColumn(name = "order_master_id", referencedColumnName = "order_master_id")
    @ManyToOne(optional = false)
    private OrderMaster orderMasterId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private ProductMaster productId;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetail(Integer orderDetailId, int orderNumber, float orderPrice) {
        this.orderDetailId = orderDetailId;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderMaster getOrderMasterId() {
        return orderMasterId;
    }

    public void setOrderMasterId(OrderMaster orderMasterId) {
        this.orderMasterId = orderMasterId;
    }

    public ProductMaster getProductId() {
        return productId;
    }

    public void setProductId(ProductMaster productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailId != null ? orderDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderDetailId == null && other.orderDetailId != null) || (this.orderDetailId != null && !this.orderDetailId.equals(other.orderDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.order.web.DAO.entity.OrderDetail[ orderDetailId=" + orderDetailId + " ]";
    }
    
}
