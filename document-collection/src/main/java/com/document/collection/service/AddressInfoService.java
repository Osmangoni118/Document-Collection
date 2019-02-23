/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.service;

import com.document.collection.dto.AddressDTO;
import com.document.collection.entity.AddressInfo;
import com.document.collection.repository.AddressInfoRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author osman
 */
@Service
public class AddressInfoService {

    @Autowired
    private AddressInfoRepo addressInfoRepo;

    @Autowired
    private UserBasicInfoService basicInfoService;

    public boolean isSaveOrUpdateAddressInfo(AddressDTO addressDTO) throws Exception {
        AddressInfo addressInfo = copyAddressInfoFromDTO(addressDTO);
        if (addressInfo != null) {
            addressInfo.setUserBasicInfo(basicInfoService.copyUserBasicInfoFromDTO(addressDTO.getUserBasicDTO()));
            addressInfoRepo.save(addressInfo);
            return true;
        }
        return false;
    }

    public AddressInfo copyAddressInfoFromDTO(AddressDTO addressDTO) {
        if (addressDTO.getAddressID() != null || addressDTO.getAddressType() != null) {
            AddressInfo addressInfo = new AddressInfo();
            BeanUtils.copyProperties(addressDTO, addressInfo);
            return addressInfo;
        }
        return null;
    }

    public AddressDTO copyAddressDtoFromEntity(AddressInfo addressInfo) {
        if (addressInfo.getAddressID() != null) {
            AddressDTO addressDTO = new AddressDTO();
            BeanUtils.copyProperties(addressInfo, addressDTO);
            return addressDTO;
        }
        return null;
    }
}
