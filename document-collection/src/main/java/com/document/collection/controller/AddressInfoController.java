/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.controller;

import com.document.collection.dto.AddressDTO;
import com.document.collection.dto.UserBasicDTO;
import com.document.collection.service.AddressInfoService;
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
public class AddressInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressInfoController.class);
    @Autowired
    private AddressInfoService addressInfoService;

    @RequestMapping(value = "/address/add-or-edit", method = RequestMethod.POST)
    public ResponseEntity<AddressDTO> saveOrUpdateUserBasicInfo(@RequestBody AddressDTO addressDTO) {
        try {
            boolean status = addressInfoService.isSaveOrUpdateAddressInfo(addressDTO);
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

    @RequestMapping(value = "/address/list-by-user", method = RequestMethod.POST)
    public List<AddressDTO> findAddressListByUserBasic(@RequestBody UserBasicDTO basicDTO) throws Exception {
        return addressInfoService.findAddressListByUserBasic(basicDTO);
    }
}
