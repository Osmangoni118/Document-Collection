/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.service;

import com.document.collection.dto.UserBasicDTO;
import com.document.collection.dto.UserDocumentDTO;
import com.document.collection.entity.UserDocumentInfo;
import com.document.collection.repository.UserDocumentInfoRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author osman
 */
@Service
public class UserDocumentInfoService {

    @Autowired
    private UserDocumentInfoRepo documentInfoRepo;

    @Autowired
    private UserBasicInfoService basicInfoService;

    public boolean isSaveOrUpdateUserDocumentInfo(UserDocumentDTO documentDTO) throws Exception {
        UserDocumentInfo documentInfo = copyUserDocumentInfoFromDTO(documentDTO);
        if (documentInfo != null) {
            documentInfo.setUserBasicInfo(basicInfoService.copyUserBasicInfoFromDTO(documentDTO.getUserBasicDTO()));
            documentInfoRepo.save(documentInfo);
            return true;
        }
        return false;
    }

    public List<UserDocumentDTO> findUserDocumentListByUserBasic(UserBasicDTO basicDTO) throws Exception {
        List<UserDocumentDTO> documentDTOs = new ArrayList<>();
        List<UserDocumentInfo> documentInfos = documentInfoRepo.findByUserBasicInfo(basicInfoService.copyUserBasicInfoFromDTO(basicDTO));
        documentInfos.stream().forEach((d) -> {
            UserDocumentDTO documentDTO = copyUserDocumentDtoFromEntity(d);
//            documentDTO.setUserBasicDTO(basicInfoService.copyUserBasicDTOfromEntity(d.getUserBasicInfo()));
            documentDTOs.add(documentDTO);
        });
        return documentDTOs;
    }
    
    public List<UserDocumentDTO> findUserDocumentListByDocumentType(String documentType) throws Exception {
        List<UserDocumentDTO> documentDTOs = new ArrayList<>();
        List<UserDocumentInfo> documentInfos = documentInfoRepo.findByDocumentType(documentType);
        documentInfos.stream().forEach((d) -> {
            UserDocumentDTO documentDTO = copyUserDocumentDtoFromEntity(d);
//            documentDTO.setUserBasicDTO(basicInfoService.copyUserBasicDTOfromEntity(d.getUserBasicInfo()));
            documentDTOs.add(documentDTO);
        });
        return documentDTOs;
    }

    public UserDocumentInfo copyUserDocumentInfoFromDTO(UserDocumentDTO documentDTO) {
        if (documentDTO.getDocumentID() != null || documentDTO.getDocumentType() != null) {
            UserDocumentInfo documentInfo = new UserDocumentInfo();
            BeanUtils.copyProperties(documentDTO, documentInfo);
            return documentInfo;
        }
        return null;
    }

    public UserDocumentDTO copyUserDocumentDtoFromEntity(UserDocumentInfo documentInfo) {
        if (documentInfo.getDocumentID() != null) {
            UserDocumentDTO documentDTO = new UserDocumentDTO();
            BeanUtils.copyProperties(documentInfo, documentDTO);
            return documentDTO;
        }
        return null;
    }
}
