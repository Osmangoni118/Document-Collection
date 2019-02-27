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
@Table(name = "user_basic_info")
public class UserBasicInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_basic_id")
    private Long userBasicID;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @NotNull
    @Column(name = "mobile_no", unique = true)
    private String mobileNo;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "religion")
    private String religion;
    
    @Column(name = "registration_date")    
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    public Long getUserBasicID() {
        return userBasicID;
    }

    public void setUserBasicID(Long userBasicID) {
        this.userBasicID = userBasicID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userBasicID != null ? userBasicID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBasicInfo)) {
            return false;
        }
        UserBasicInfo other = (UserBasicInfo) object;
        if ((this.userBasicID == null && other.userBasicID != null) || (this.userBasicID != null && !this.userBasicID.equals(other.userBasicID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.document.collection.entity.UserBasicInfo[ id=" + userBasicID + " ]";
    }
    
}
