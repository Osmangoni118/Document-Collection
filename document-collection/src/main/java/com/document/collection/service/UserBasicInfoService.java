/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.service;

import com.document.collection.dto.UserBasicDTO;
import com.document.collection.entity.UserBasicInfo;
import com.document.collection.repository.UserBasicInfoRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author osman
 */
@Service
public class UserBasicInfoService {

    @Autowired
    private UserBasicInfoRepo basicInfoRepo;

    public boolean isSaveOrUpdateUserBasicInfo(UserBasicDTO basicDTO) throws Exception {
        UserBasicInfo basicInfo = copyUserBasicInfoFromDTO(basicDTO);
        if (basicInfo != null) {
            basicInfoRepo.save(basicInfo);
            return true;
        }
        return false;
    }

    public UserBasicInfo copyUserBasicInfoFromDTO(UserBasicDTO basicDTO) {
        if (basicDTO.getUserBasicID() != null || basicDTO.getMobileNo() != null) {
            UserBasicInfo basicInfo = new UserBasicInfo();
            BeanUtils.copyProperties(basicDTO, basicInfo);
            return basicInfo;
        }
        return null;
    }

    public UserBasicDTO copyUserBasicDTOfromEntity(UserBasicInfo basicInfo) {
        if (basicInfo.getUserBasicID() != null) {
            UserBasicDTO basicDTO = new UserBasicDTO();
            BeanUtils.copyProperties(basicInfo, basicDTO);
            return basicDTO;
        }
        return null;
    }
}
