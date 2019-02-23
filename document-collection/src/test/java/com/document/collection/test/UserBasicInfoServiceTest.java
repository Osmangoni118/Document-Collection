/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.test;

import com.document.collection.dto.UserBasicDTO;
import com.document.collection.dto.UserFullInformationDTO;
import com.document.collection.repository.UserBasicInfoRepo;
import com.document.collection.service.UserBasicInfoService;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
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
public class UserBasicInfoServiceTest {

    @Autowired
    private UserBasicInfoService basicInfoService;
    


//    @Test
//    public void saveOrUpdateUserBasicInfoTest() throws Exception {
//        UserBasicDTO basicDTO = new UserBasicDTO();
//        basicDTO.setFirstName("Osman");
//        basicDTO.setLastName("Goni");
//        basicDTO.setEmail("mdosman@gmail.com");
//        basicDTO.setMobileNo("01840033136");
//        basicDTO.setRegistrationDate(new Date());
//        boolean check = basicInfoService.isSaveOrUpdateUserBasicInfo(basicDTO);
//        assertEquals(true, check);
//    }
    
    @Test
    public void findUserbasicInfoList() throws Exception{
        List<UserBasicDTO> basicDTOs = basicInfoService.findAllUserBasic();
        assertNotEquals(0, basicDTOs);        
    }
    
    @Test
    public void findFullUserbasicInfo() throws Exception{
        UserBasicDTO basicDTO = basicInfoService.findUserBasicDTO(1l);
        UserFullInformationDTO dTO = basicInfoService.findUserFullInformatinDtoByUserBasic(basicDTO);
        assertNotNull(dTO);
    }
    
    public UserBasicDTO createUserBasicDTO(){
        UserBasicDTO basicDTO = new UserBasicDTO();
        basicDTO.setUserBasicID(1l);
        return basicDTO;
    }
    
}
