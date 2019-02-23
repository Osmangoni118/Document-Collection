/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.document.collection.test;

import com.document.collection.dto.UserBasicDTO;
import com.document.collection.dto.UserDocumentDTO;
import com.document.collection.service.UserBasicInfoService;
import com.document.collection.service.UserDocumentInfoService;
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
public class UserDocumentInfoServiceTest {
    
    @Autowired
    private UserDocumentInfoService documentInfoService;
    @Autowired
    private UserBasicInfoService basicInfoService;
//    @Test
//    public void saveOrUpdateUserDocumentInfoForNID() throws Exception{
//        UserDocumentDTO documentDTO = new UserDocumentDTO();
//        documentDTO.setDocumentType("NID");
//        documentDTO.setNidNumber(511732478965441l);
//        documentDTO.setNationality("Bangladeshi");
//        documentDTO.setGender("Male");
//        documentDTO.setReligion("Islam");
//        documentDTO.setFileName("osmangoni.png");
//        documentDTO.setFilePath("C://images/");
//        documentDTO.setUserBasicDTO(createUserBasicDTO());
//        boolean check = documentInfoService.isSaveOrUpdateUserDocumentInfo(documentDTO);
//        assertEquals(true, check);
//    }
    
//    @Test
//    public void saveOrUpdateUserDocumentInfoForBirthCertificate() throws Exception{
//        UserDocumentDTO documentDTO = new UserDocumentDTO();
//        documentDTO.setDocumentType("Birth Certificate");
//        documentDTO.setBirthCertificateNo(5117321565441l);
//        documentDTO.setNationality("Bangladeshi");
//        documentDTO.setGender("Male");
//        documentDTO.setReligion("Islam");
//        documentDTO.setFileName("osmangoni.png");
//        documentDTO.setFilePath("C://images/");
//        documentDTO.setUserBasicDTO(addressInfoServiceTest.createUserBasicDTO());
//        boolean check = documentInfoService.isSaveOrUpdateUserDocumentInfo(documentDTO);
//        assertEquals(true, check);
//    }
//    
//    @Test
//    public void saveOrUpdateUserDocumentInfoForPassport() throws Exception{
//        UserDocumentDTO documentDTO = new UserDocumentDTO();
//        documentDTO.setDocumentType("Passport");
//        documentDTO.setOthersDocumentNo(515478965441l);
//        documentDTO.setNationality("Bangladeshi");
//        documentDTO.setGender("Male");
//        documentDTO.setReligion("Islam");
//        documentDTO.setCitizenshipStatus("By Birth");
//        documentDTO.setDualCitizenship("No");
//        documentDTO.setFileName("osmangoni.png");
//        documentDTO.setFilePath("C://images/");
//        documentDTO.setUserBasicDTO(addressInfoServiceTest.createUserBasicDTO());
//        boolean check = documentInfoService.isSaveOrUpdateUserDocumentInfo(documentDTO);
//        assertEquals(true, check);
//    }
    
    @Test
    public void findUserDocumentByUserBasic() throws Exception{
        UserBasicDTO basicDTO = basicInfoService.findUserBasicDTO(1l);
        List<UserDocumentDTO> documentDTOs = documentInfoService.findUserDocumentListByUserBasic(basicDTO);
        assertNotEquals(0, documentDTOs);
    }
    
    @Test
    public void findUserDocumentByDocumentType() throws Exception{
        List<UserDocumentDTO> documentDTOs = documentInfoService.findUserDocumentListByDocumentType("NID");
        assertNotEquals(0, documentDTOs);
    }
    
     public UserBasicDTO createUserBasicDTO(){
        UserBasicDTO basicDTO = new UserBasicDTO();
        basicDTO.setUserBasicID(1l);       
        return basicDTO;
    }
}
