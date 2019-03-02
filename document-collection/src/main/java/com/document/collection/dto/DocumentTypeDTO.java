/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.dto;

/**
 *
 * @author osman
 */
public class DocumentTypeDTO {

    private Long id;
    private String typeName;
    private String description;
    private int documentNo;
    private int documentName;
    private int verified;
    private int documentValidity;
    private int others;
    private UserBasicDTO basicDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserBasicDTO getBasicDTO() {
        return basicDTO;
    }

    public void setBasicDTO(UserBasicDTO basicDTO) {
        this.basicDTO = basicDTO;
    }

    public int getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(int documentNo) {
        this.documentNo = documentNo;
    }

    public int getDocumentName() {
        return documentName;
    }

    public void setDocumentName(int documentName) {
        this.documentName = documentName;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public int getDocumentValidity() {
        return documentValidity;
    }

    public void setDocumentValidity(int documentValidity) {
        this.documentValidity = documentValidity;
    }

    public int getOthers() {
        return others;
    }

    public void setOthers(int others) {
        this.others = others;
    }
}
