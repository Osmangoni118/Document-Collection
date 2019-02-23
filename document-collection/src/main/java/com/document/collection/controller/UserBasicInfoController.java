/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.controller;

import com.document.collection.dto.UserBasicDTO;
import com.document.collection.dto.UserFullInformationDTO;
import com.document.collection.service.UserBasicInfoService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author osman
 */
@RestController
public class UserBasicInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserBasicInfoController.class);

    @Autowired
    private UserBasicInfoService basicInfoService;

    @RequestMapping(value = "/users/add-or-edit", method = RequestMethod.POST)
    public ResponseEntity<UserBasicDTO> saveOrUpdateUserBasic(@RequestBody UserBasicDTO basicDTO) {
        try {
            boolean status = basicInfoService.isSaveOrUpdateUserBasicInfo(basicDTO);
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

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserBasicDTO> findAllUserBasicList() throws Exception {
        return basicInfoService.findAllUserBasic();
    }

    @RequestMapping(value = "/users/user-full-information", method = RequestMethod.POST)
    public ResponseEntity<UserFullInformationDTO> findUserFullInformationByUserBasic(@RequestBody UserBasicDTO basicDTO) {
        try {
            UserFullInformationDTO fullInformationDTO = basicInfoService.findUserFullInformatinDtoByUserBasic(basicDTO);
            if (fullInformationDTO != null) {
                return new ResponseEntity(fullInformationDTO, HttpStatus.FOUND);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            LOGGER.error("ERROR for : " + e);
            LOGGER.debug("DEBUG for : " + e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String findHomePage() {
        return "Home Page";
    }
}
