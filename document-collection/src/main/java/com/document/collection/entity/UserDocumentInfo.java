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
@Table(name = "user_document", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_basic_id", "document_name"})
})
public class UserDocumentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentID;

    @NotNull
    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "nid_number", unique = true)
    private Long nidNumber;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "religion")
    private String religion;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_certificate_no", unique = true)
    private Long birthCertificateNo;

    @Column(name = "others_document_no", unique = true)
    private Long othersDocumentNo;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "citizenship_status")
    private String citizenshipStatus;

    @Column(name = "dual_citizenship")
    private String dualCitizenship;

    @Column(name = "executed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date executedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_basic_id")
    private UserBasicInfo userBasicInfo;

    public Long getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Long documentID) {
        this.documentID = documentID;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Long getNidNumber() {
        return nidNumber;
    }

    public void setNidNumber(Long nidNumber) {
        this.nidNumber = nidNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getBirthCertificateNo() {
        return birthCertificateNo;
    }

    public void setBirthCertificateNo(Long birthCertificateNo) {
        this.birthCertificateNo = birthCertificateNo;
    }

    public Long getOthersDocumentNo() {
        return othersDocumentNo;
    }

    public void setOthersDocumentNo(Long othersDocumentNo) {
        this.othersDocumentNo = othersDocumentNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCitizenshipStatus() {
        return citizenshipStatus;
    }

    public void setCitizenshipStatus(String citizenshipStatus) {
        this.citizenshipStatus = citizenshipStatus;
    }

    public String getDualCitizenship() {
        return dualCitizenship;
    }

    public void setDualCitizenship(String dualCitizenship) {
        this.dualCitizenship = dualCitizenship;
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
        hash += (documentID != null ? documentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDocumentInfo)) {
            return false;
        }
        UserDocumentInfo other = (UserDocumentInfo) object;
        if ((this.documentID == null && other.documentID != null) || (this.documentID != null && !this.documentID.equals(other.documentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.document.collection.entity.UserDocumentInfo[ id=" + documentID + " ]";
    }

}
