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
    private String storageAddress;
    private boolean multipleDocument;
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

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    public boolean isMultipleDocument() {
        return multipleDocument;
    }

    public void setMultipleDocument(boolean multipleDocument) {
        this.multipleDocument = multipleDocument;
    }

    public UserBasicDTO getBasicDTO() {
        return basicDTO;
    }

    public void setBasicDTO(UserBasicDTO basicDTO) {
        this.basicDTO = basicDTO;
    }
}
