/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.dto;

import java.util.List;

/**
 *
 * @author osman
 */
public class UserFullInformationDTO {
    
    private UserBasicDTO userBasicDTO;
    private List<AddressDTO> addressDTOs;
    private List<UserDocumentDTO> userDocumentDTOs;

    public UserBasicDTO getUserBasicDTO() {
        return userBasicDTO;
    }

    public void setUserBasicDTO(UserBasicDTO userBasicDTO) {
        this.userBasicDTO = userBasicDTO;
    }

    public List<AddressDTO> getAddressDTOs() {
        return addressDTOs;
    }

    public void setAddressDTOs(List<AddressDTO> addressDTOs) {
        this.addressDTOs = addressDTOs;
    }

    public List<UserDocumentDTO> getUserDocumentDTOs() {
        return userDocumentDTOs;
    }

    public void setUserDocumentDTOs(List<UserDocumentDTO> userDocumentDTOs) {
        this.userDocumentDTOs = userDocumentDTOs;
    }   
        
}
