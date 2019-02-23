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
public class UserDocumentDTO {
    private Long documentID;
    private String documentType;
    private String documentName;
    private Long nidNumber;
    private Date dateOfBirth;
    private String religion;
    private String gender;
    private Long birthCertificateNo;
    private Long othersDocumentNo;
    private String fileName;
    private String filePath;
    private String nationality;
    private String citizenshipStatus;
    private String dualCitizenship;
    private Date executedDate;
    private UserBasicDTO userBasicDTO;

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

    public UserBasicDTO getUserBasicDTO() {
        return userBasicDTO;
    }

    public void setUserBasicDTO(UserBasicDTO userBasicDTO) {
        this.userBasicDTO = userBasicDTO;
    }
    
}
