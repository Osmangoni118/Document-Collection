/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.service;

import com.document.collection.dto.DocumentPropertyDTO;
import com.document.collection.entity.DocumentProperty;
import com.document.collection.repository.DocumentPropertyRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author osman
 */
@Service
public class DocumentPropertyService {

    @Autowired
    private DocumentPropertyRepo documentPropertyRepo;

    @Autowired
    private UserBasicInfoService basicInfoService;

    @Autowired
    private DocumentTypeService documentTypeService;

    public boolean isSaveDocumentProperty(DocumentPropertyDTO documentPropertyDTO) throws DataIntegrityViolationException, Exception {
        DocumentProperty documentProperty = copyDocumentPropertyFromDTO(documentPropertyDTO);
        if (documentProperty != null) {
            documentProperty.setDocumentType(documentTypeService.copyDocumentTypeFromDTO(documentPropertyDTO.getDocumentTypeDTO()));
            documentPropertyRepo.save(documentProperty);
            return true;
        }
        return false;
    }

    public List<DocumentPropertyDTO> findDocumentPropertiesByTypeId(Long typeId) {
        List<DocumentPropertyDTO> documentPropertyDTOs = new ArrayList<>();
        List<DocumentProperty> documentPropertys = documentPropertyRepo.findByDocumentType_Id(typeId);
        documentPropertys.stream().forEach((d) -> {
            DocumentPropertyDTO dTO = copyDocumentPropertyFromEntity(d);
            dTO.setDocumentTypeDTO(documentTypeService.copyDocumentTypeFromEntity(d.getDocumentType()));
            documentPropertyDTOs.add(dTO);
        });
        return documentPropertyDTOs;
    }

    public DocumentProperty copyDocumentPropertyFromDTO(DocumentPropertyDTO documentPropertyDTO) {
        if (documentPropertyDTO.getId() != null || documentPropertyDTO.getPropertyName() != null) {
            DocumentProperty documentProperty = new DocumentProperty();
            BeanUtils.copyProperties(documentPropertyDTO, documentProperty);
            return documentProperty;
        }
        return null;
    }

    public DocumentPropertyDTO copyDocumentPropertyFromEntity(DocumentProperty documentProperty) {
        if (documentProperty.getId() != null) {
            DocumentPropertyDTO documentPropertyDTO = new DocumentPropertyDTO();
            BeanUtils.copyProperties(documentProperty, documentPropertyDTO);
            return documentPropertyDTO;
        }
        return null;
    }
}
