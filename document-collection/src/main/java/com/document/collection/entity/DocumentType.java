/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author osman
 */
@Entity
@Table(name = "document_type")
public class DocumentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type_name")
    private String typeName;
    @Column(name = "description")
    private String description;
    @Column(name = "document_no")
    private int documentNo;
    @Column(name = "document_name")
    private int documentName;
    @Column(name = "verified")
    private int verified;
    @Column(name = "document_validity")
    private int documentValidity;
    @Column(name = "others")
    private int others;
    @ManyToOne
    @JoinColumn(name = "user_basic_id")
    private UserBasicInfo basicInfo;

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

    public UserBasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(UserBasicInfo basicInfo) {
        this.basicInfo = basicInfo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentType)) {
            return false;
        }
        DocumentType other = (DocumentType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.document.collection.entity.DocumentType[ id=" + id + " ]";
    }

}
