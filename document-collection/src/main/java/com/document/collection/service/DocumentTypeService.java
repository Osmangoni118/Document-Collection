/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.service;

import com.document.collection.dto.DocumentTypeDTO;
import com.document.collection.entity.DocumentType;
import com.document.collection.repository.DocumentTypeRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author osman
 */
@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepo documentTypeRepo;

    @Autowired
    private UserBasicInfoService basicInfoService;

    public boolean isSaveDocumentType(DocumentTypeDTO documentTypeDTO) throws DataIntegrityViolationException, Exception {
        DocumentType documentType = copyDocumentTypeFromDTO(documentTypeDTO);
        if (documentType != null) {
            documentType.setBasicInfo(basicInfoService.copyUserBasicInfoFromDTO(documentTypeDTO.getBasicDTO()));
            documentTypeRepo.save(documentType);
            return true;
        }
        return false;
    }

    public List<DocumentTypeDTO> findDocumentTypeDtoByUserId(Long userId) throws Exception {
        List<DocumentTypeDTO> documentTypeDTOs = new ArrayList<>();
        List<DocumentType> documentTypes = documentTypeRepo.findByBasicInfo_UserBasicID(userId);
        documentTypes.stream().forEach((d) -> {
            DocumentTypeDTO dTO = copyDocumentTypeFromEntity(d);
            dTO.setBasicDTO(basicInfoService.copyUserBasicDTOfromEntity(d.getBasicInfo()));
            documentTypeDTOs.add(dTO);

        });
        return documentTypeDTOs;
    }

    public DocumentType copyDocumentTypeFromDTO(DocumentTypeDTO documentTypeDTO) {
        if (documentTypeDTO.getId() != null || documentTypeDTO.getTypeName() != null) {
            DocumentType documentType = new DocumentType();
            BeanUtils.copyProperties(documentTypeDTO, documentType);
            return documentType;
        }
        return null;
    }

    public DocumentTypeDTO copyDocumentTypeFromEntity(DocumentType documentType) {
        if (documentType.getId() != null) {
            DocumentTypeDTO documentTypeDTO = new DocumentTypeDTO();
            BeanUtils.copyProperties(documentType, documentTypeDTO);
            return documentTypeDTO;
        }
        return null;
    }
}
