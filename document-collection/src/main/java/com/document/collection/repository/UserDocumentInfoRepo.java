/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.repository;

import com.document.collection.entity.UserDocumentInfo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author osman
 */
public interface UserDocumentInfoRepo extends CrudRepository<UserDocumentInfo, Long>{
    
}