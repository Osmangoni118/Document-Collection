/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.service;

import com.document.collection.dto.DocumentDTO;
import com.document.collection.entity.Document;
import com.document.collection.repository.DocumentRepo;
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
public class DocumentService {

    @Autowired
    private DocumentRepo documentRepo;
    @Autowired
    private UserBasicInfoService basicInfoService;
    @Autowired
    private DocumentTypeService documentTypeService;

    public boolean isSaveDocument(DocumentDTO documentDTO) throws DataIntegrityViolationException, Exception {
        Document document = copyDocumentFromDTO(documentDTO);
        if (document != null) {
            document.setBasicInfo(basicInfoService.copyUserBasicInfoFromDTO(documentDTO.getBasicDTO()));
            document.setDocumentType(documentTypeService.copyDocumentTypeFromDTO(documentDTO.getDocumentTypeDTO()));
            documentRepo.save(document);
            return true;
        }
        return false;
    }

    public DocumentDTO findDocumentByTypeId(Long typeId) throws Exception {
        Document document = documentRepo.findByDocumentType_Id(typeId);
        if (document != null) {
            DocumentDTO documentDTO = copyDocumentFromEntity(document);
            documentDTO.setBasicDTO(basicInfoService.copyUserBasicDTOfromEntity(document.getBasicInfo()));
            return documentDTO;
        }
        return null;
    }

    public List<DocumentDTO> findDocumentListByUser(Long userBasicID) throws Exception {
        List<DocumentDTO> documentDTOs = new ArrayList<>();
        List<Document> documents = documentRepo.findByBasicInfo_userBasicID(userBasicID);
        documents.stream().forEach((d) -> {
            DocumentDTO dTO = copyDocumentFromEntity(d);
            dTO.setBasicDTO(basicInfoService.copyUserBasicDTOfromEntity(d.getBasicInfo()));
            dTO.setDocumentTypeDTO(documentTypeService.copyDocumentTypeFromEntity(d.getDocumentType()));
            documentDTOs.add(dTO);
        });
        return documentDTOs;
    }

    public Document copyDocumentFromDTO(DocumentDTO documentDTO) {
        if (documentDTO.getId() != null || documentDTO.getDocumentTypeDTO() != null) {
            Document document = new Document();
            BeanUtils.copyProperties(documentDTO, document);
            return document;
        }
        return null;
    }

    public DocumentDTO copyDocumentFromEntity(Document document) {
        if (document.getId() != null) {
            DocumentDTO documentDTO = new DocumentDTO();
            BeanUtils.copyProperties(document, documentDTO);
            return documentDTO;
        }
        return null;
    }

}
