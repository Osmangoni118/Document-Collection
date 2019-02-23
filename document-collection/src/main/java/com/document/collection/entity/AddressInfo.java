/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author osman
 */
@Entity
@Table(name = "address_info", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_basic_id", "address_type"})
})
public class AddressInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressID;
    
    @Column(name = "village")
    private String village;
    
    @Column(name = "post_office")
    private String postOffice;
    
    @Column(name = "thana")
    private String thana;
    
    @Column(name = "district")
    private String district;
    
    @NotNull
    @Column(name = "address_type")
    private String addressType;
    
    @Column(name = "zip_code")
    private String zipCode;
    
    @Column(name = "executed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date executedDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_basic_id")
    private UserBasicInfo userBasicInfo;

    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Date getExecutedDate() {
        return executedDate;
    }

    public void setExecutedDate(Date executedDate) {
        this.executedDate = executedDate;
    }

    public UserBasicInfo getUserBasicInfo() {
        return userBasicInfo;
    }

    public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
        this.userBasicInfo = userBasicInfo;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressID != null ? addressID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressInfo)) {
            return false;
        }
        AddressInfo other = (AddressInfo) object;
        if ((this.addressID == null && other.addressID != null) || (this.addressID != null && !this.addressID.equals(other.addressID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.document.collection.entity.AddressInfo[ id=" + addressID + " ]";
    }
    
}
