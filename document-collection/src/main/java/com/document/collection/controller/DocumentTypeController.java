/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.controller;

import com.document.collection.dto.DocumentTypeDTO;
import com.document.collection.service.DocumentTypeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author osman
 */
@RestController
@RequestMapping(value = "api/document/")
public class DocumentTypeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentTypeController.class);
    @Autowired
    private DocumentTypeService documentTypeService;
    
    
    @RequestMapping(value = "/types", method = RequestMethod.POST)
    public ResponseEntity<DocumentTypeDTO> saveDocumentType(@RequestBody DocumentTypeDTO documentTypeDTO) {
        try {
            boolean status = documentTypeService.isSaveDocumentType(documentTypeDTO);
            if (status) {
                return new ResponseEntity(HttpStatus.CREATED);
            } else {
                return new ResponseEntity(HttpStatus.IM_USED);
            }
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("ERROR for : " + e);
            LOGGER.debug("DEBUG for : " + e);
            return new ResponseEntity(HttpStatus.IM_USED);
        } catch (Exception e) {
            LOGGER.error("ERROR for : " + e);
            LOGGER.debug("DEBUG for : " + e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<DocumentTypeDTO> findDocumentTypeListById(@RequestParam Long id) throws Exception {
        return documentTypeService.findDocumentTypeDtoByUserId(id);
    }

}
