/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.dto;

import java.util.Date;

/**
 *
 * @author osman
 */
public class AddressDTO {

    private Long addressID;
    private String village;
    private String postOffice;
    private String thana;
    private String district;
    private String addressType;
    private String zipCode;
    private Date executedDate;
    private UserBasicDTO userBasicDTO;

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

    public UserBasicDTO getUserBasicDTO() {
        return userBasicDTO;
    }

    public void setUserBasicDTO(UserBasicDTO userBasicDTO) {
        this.userBasicDTO = userBasicDTO;
    }
    
}
