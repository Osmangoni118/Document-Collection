/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.service;

import com.document.collection.dto.UserBasicDTO;
import com.document.collection.dto.UserFullInformationDTO;
import com.document.collection.entity.UserBasicInfo;
import com.document.collection.repository.UserBasicInfoRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Autowired
    private AddressInfoService addressInfoService;

    @Autowired
    private UserDocumentInfoService documentInfoService;

    public boolean isSaveOrUpdateUserBasicInfo(UserBasicDTO basicDTO) throws Exception {
        UserBasicInfo basicInfo = copyUserBasicInfoFromDTO(basicDTO);
        if (basicInfo != null) {
            basicInfoRepo.save(basicInfo);
            return true;
        }
        return false;
    }

    public UserFullInformationDTO findUserFullInformatinDtoByUserBasic(UserBasicDTO basicDTO) throws Exception {
        UserFullInformationDTO fullInformationDTO = new UserFullInformationDTO();
        fullInformationDTO.setUserBasicDTO(basicDTO);
        fullInformationDTO.setAddressDTOs(addressInfoService.findAddressListByUserBasic(basicDTO));
        fullInformationDTO.setUserDocumentDTOs(documentInfoService.findUserDocumentListByUserBasic(basicDTO));
        return fullInformationDTO;
    }

    public List<UserBasicDTO> findAllUserBasic() throws Exception {
        List<UserBasicDTO> basicDTOs = new ArrayList<>();
        List<UserBasicInfo> basicInfos = (List<UserBasicInfo>) basicInfoRepo.findAll();
        basicInfos.stream().forEach((u) -> {
            UserBasicDTO basicDTO = copyUserBasicDTOfromEntity(u);
            basicDTOs.add(basicDTO);
        });
        return basicDTOs;
    }

    public UserBasicDTO findUserBasicDTO(Long id) throws Exception {
        UserBasicDTO basicDTO = new UserBasicDTO();
        Optional<UserBasicInfo> basicInfo = basicInfoRepo.findById(id);
        BeanUtils.copyProperties(basicInfo, basicDTO);
        return basicDTO;
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
