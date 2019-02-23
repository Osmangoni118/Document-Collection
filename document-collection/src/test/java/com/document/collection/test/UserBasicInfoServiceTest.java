/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.test;

import com.document.collection.dto.UserBasicDTO;
import com.document.collection.service.UserBasicInfoService;
import java.util.Date;
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


    @Test
    public void saveOrUpdateUserBasicInfoTest() throws Exception {
        UserBasicDTO basicDTO = new UserBasicDTO();
        basicDTO.setFirstName("Osman");
        basicDTO.setLastName("Goni");
        basicDTO.setEmail("mdosman@gmail.com");
        basicDTO.setMobileNo("01840033126");
        basicDTO.setRegistrationDate(new Date());
        boolean check = basicInfoService.isSaveOrUpdateUserBasicInfo(basicDTO);
        assertEquals(true, check);
    }
    
}
