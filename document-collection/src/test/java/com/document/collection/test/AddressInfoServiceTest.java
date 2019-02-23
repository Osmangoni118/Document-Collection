/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.test;

import com.document.collection.dto.AddressDTO;
import com.document.collection.dto.UserBasicDTO;
import com.document.collection.service.AddressInfoService;
import com.document.collection.service.UserBasicInfoService;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author osman
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressInfoServiceTest {
    
    @Autowired
    private AddressInfoService addressInfoService;
    @Autowired
    private UserBasicInfoService basicInfoService;
    
//    @Test
//    public void saveOrUpdateAddressInfoForPresentAddress() throws Exception{
//        AddressDTO addressDTO = new AddressDTO();
//        addressDTO.setAddressType("Present Address");
//        addressDTO.setVillage("CharLuxmi");
//        addressDTO.setPostOffice("Ramgatir Haat");
//        addressDTO.setThana("Ramgati");
//        addressDTO.setDistrict("Luxmipur");
//        addressDTO.setExecutedDate(new Date());
//        addressDTO.setUserBasicDTO(createUserBasicDTO());
//        boolean check = addressInfoService.isSaveOrUpdateAddressInfo(addressDTO);
//        assertEquals(true, check);
//    }
//    @Test
//    public void saveOrUpdateAddressInfoForPermanentAddress() throws Exception{
//        AddressDTO addressDTO = new AddressDTO();
//        addressDTO.setAddressType("Permanent Address");
//        addressDTO.setPostOffice("Badda");
//        addressDTO.setThana("Badda");
//        addressDTO.setDistrict("Dhaka");
//        addressDTO.setExecutedDate(new Date());
//        addressDTO.setUserBasicDTO(createUserBasicDTO());
//        boolean check = addressInfoService.isSaveOrUpdateAddressInfo(addressDTO);
//        assertEquals(true, check);
//    }
//    @Test
//    public void saveOrUpdateAddressInfoForOfficeAddress() throws Exception{
//        AddressDTO addressDTO = new AddressDTO();
//        addressDTO.setAddressType("Office Address");
//        addressDTO.setPostOffice("Mohakhali");
//        addressDTO.setThana("Tejgaon");
//        addressDTO.setDistrict("Dhaka");
//        addressDTO.setExecutedDate(new Date());
//        addressDTO.setUserBasicDTO(createUserBasicDTO());
//        boolean check = addressInfoService.isSaveOrUpdateAddressInfo(addressDTO);
//        assertEquals(true, check);
//    }
    
    @Test
    public void findAddressListByUser() throws Exception{
        UserBasicDTO basicDTO = basicInfoService.findUserBasicDTO(1l);
        List<AddressDTO> addressDTOs = addressInfoService.findAddressListByUserBasic(basicDTO);
        assertNotEquals(0, addressDTOs);
    }
    
    public UserBasicDTO createUserBasicDTO(){
        UserBasicDTO basicDTO = new UserBasicDTO();
        basicDTO.setUserBasicID(1l);
        return basicDTO;
    }
}
