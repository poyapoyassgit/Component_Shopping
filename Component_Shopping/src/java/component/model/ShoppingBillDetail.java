/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component.model;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wachirapong
 */
@Entity
@Table(name = "ShoppingBillDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingBillDetail.findAll", query = "SELECT s FROM ShoppingBillDetail s")
    , @NamedQuery(name = "ShoppingBillDetail.findByShoppingBillDetailseq", query = "SELECT s FROM ShoppingBillDetail s WHERE s.shoppingBillDetailseq = :shoppingBillDetailseq")})
public class ShoppingBillDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShoppingBillDetail_seq")
    private Integer shoppingBillDetailseq;
    @JoinColumn(name = "ShoppingBillDetail_dvdItem", referencedColumnName = "DvdData_id")
    @ManyToOne
    private DvdData shoppingBillDetaildvdItem;
    @JoinColumn(name = "ShoppingBillDetail_bill", referencedColumnName = "ShoppingBill_id")
    @ManyToOne
    private ShoppingBill shoppingBillDetailbill;

    public ShoppingBillDetail() {
    }

    public ShoppingBillDetail(Integer shoppingBillDetailseq) {
        this.shoppingBillDetailseq = shoppingBillDetailseq;
    }

    public Integer getShoppingBillDetailseq() {
        return shoppingBillDetailseq;
    }

    public void setShoppingBillDetailseq(Integer shoppingBillDetailseq) {
        this.shoppingBillDetailseq = shoppingBillDetailseq;
    }

    public DvdData getShoppingBillDetaildvdItem() {
        return shoppingBillDetaildvdItem;
    }

    public void setShoppingBillDetaildvdItem(DvdData shoppingBillDetaildvdItem) {
        this.shoppingBillDetaildvdItem = shoppingBillDetaildvdItem;
    }

    public ShoppingBill getShoppingBillDetailbill() {
        return shoppingBillDetailbill;
    }

    public void setShoppingBillDetailbill(ShoppingBill shoppingBillDetailbill) {
        this.shoppingBillDetailbill = shoppingBillDetailbill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingBillDetailseq != null ? shoppingBillDetailseq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingBillDetail)) {
            return false;
        }
        ShoppingBillDetail other = (ShoppingBillDetail) object;
        if ((this.shoppingBillDetailseq == null && other.shoppingBillDetailseq != null) || (this.shoppingBillDetailseq != null && !this.shoppingBillDetailseq.equals(other.shoppingBillDetailseq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "component.model.ShoppingBillDetail[ shoppingBillDetailseq=" + shoppingBillDetailseq + " ]";
    }
    
}