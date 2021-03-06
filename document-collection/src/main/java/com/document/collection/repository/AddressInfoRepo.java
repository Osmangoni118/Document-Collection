/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.repository;

import com.document.collection.entity.AddressInfo;
import com.document.collection.entity.UserBasicInfo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author osman
 */
public interface AddressInfoRepo extends CrudRepository<AddressInfo, Long>{
    
    public List<AddressInfo> findByUserBasicInfo(UserBasicInfo userBasicInfo) throws Exception;
}
