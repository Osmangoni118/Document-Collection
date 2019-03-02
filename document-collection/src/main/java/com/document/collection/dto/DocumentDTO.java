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
public class DocumentDTO {
    private Long id;
    private Long documentNo;
    private String documentName;
    private boolean verified;
    private Date documentValidity;
    private String others;
    private UserBasicDTO basicDTO;
    private DocumentTypeDTO documentTypeDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(Long documentNo) {
        this.documentNo = documentNo;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Date getDocumentValidity() {
        return documentValidity;
    }

    public void setDocumentValidity(Date documentValidity) {
        this.documentValidity = documentValidity;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public UserBasicDTO getBasicDTO() {
        return basicDTO;
    }

    public void setBasicDTO(UserBasicDTO basicDTO) {
        this.basicDTO = basicDTO;
    }

    public DocumentTypeDTO getDocumentTypeDTO() {
        return documentTypeDTO;
    }

    public void setDocumentTypeDTO(DocumentTypeDTO documentTypeDTO) {
        this.documentTypeDTO = documentTypeDTO;
    }
}
