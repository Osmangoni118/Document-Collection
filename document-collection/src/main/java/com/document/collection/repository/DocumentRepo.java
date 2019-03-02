/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.repository;

import com.document.collection.entity.Document;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author osman
 */
public interface DocumentRepo extends CrudRepository<Document, Long>{
    
    public Document findByDocumentType_Id(Long id) throws Exception;
    public List<Document> findByBasicInfo_userBasicID(Long userBasicID) throws Exception;
}
