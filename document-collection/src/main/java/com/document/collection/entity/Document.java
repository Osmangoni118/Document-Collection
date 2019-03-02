/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author osman
 */
@Entity
@Table(name = "document", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_basic_id", "type_id"})
})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "document_no")
    private Long documentNo;
    @Column(name = "document_name")
    private String documentName;
    @Column(name = "verified")
    private boolean verified;
    @Temporal(TemporalType.DATE)
    @Column(name = "document_validity")
    private Date documentValidity;
    @Column(name = "others")
    private String others;
    
    @ManyToOne
    @JoinColumn(name = "user_basic_id")
    private UserBasicInfo basicInfo;
    
    @OneToOne
    @JoinColumn(name = "type_id")  
    private DocumentType documentType;
    

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

    public UserBasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(UserBasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
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
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.document.collection.entity.Document[ id=" + id + " ]";
    }
    
}
