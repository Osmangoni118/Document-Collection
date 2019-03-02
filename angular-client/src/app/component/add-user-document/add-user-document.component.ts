import { Component, OnInit, Input } from '@angular/core';
import { DocumenttypeService } from '../../service/documenttype.service';
import { UserdocumentService } from '../../service/userdocument.service';
import { DocumentpropertyService } from '../../service/documentproperty.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-user-document',
  templateUrl: './add-user-document.component.html',
  styleUrls: ['./add-user-document.component.css']
})
export class AddUserDocumentComponent implements OnInit {
  typeList: any = [];
  propertyList: any = [];
  userbasic: any = {};
  typeDto: any = {};
  typeId: any = '';


  @Input() userData = {
    documentNo: '', documentName: '', verified: 0, documentValidity: '', others: '', basicDTO: {}, documentTypeDTO: {}
  };

  constructor(private document: UserdocumentService, private rest: DocumenttypeService, private propertyService: DocumentpropertyService, private route: ActivatedRoute, private router: Router) {
    this.route.queryParams.subscribe(params => {
      console.log('param = ', params["userbasic"]);
      this.userbasic = params["userbasic"];
    });
  }

  ngOnInit() {
    this.getDocumentTypeList(JSON.parse(this.userbasic));
  }

  getDocumentTypeList(userBasic) {
    this.typeList = [];
    this.rest.getDocumentTypeListByUserId(userBasic.userBasicID).subscribe((data: {}) => {
      console.log('type list ', data);
      this.typeList = data;
    });
  }

  getDocumentPropertyList(typeId) {
    this.propertyList = [];
    this.propertyService.getDocumentPropertyListByTypeId(typeId).subscribe((data: {}) => {
      console.log('type list ', data);
      this.propertyList = data;
    });
  }

  addUserDocument() {
    console.log('user basic ', this.userbasic);
    this.userData.basicDTO = JSON.parse(this.userbasic);
    console.log('type dto ', this.typeDto);
    this.userData.documentTypeDTO = this.typeDto;
    console.log("document object : ", this.userData);
    this.document.addUserDocument(this.userData).subscribe((result) => {
      console.log('result ', result);
      if(result != null){
        alert('Data added successfully.');
      this.router.navigate(['/users']);
      }else{
        alert('Something wrong.');
      }
    }, (err) => {
      console.log(err);
    });
  }

  previousPage() {
    this.router.navigate(['/users']);
  }

  toggleVisibility(event, value) {
    console.log('value ', value.id);
    if (event.target.checked) {
      this.typeId = value.id;
      // this.userData.id = value;
      // this.getDocumentPropertyList(value)
      this.typeDto = value;
    }

  }

  documentVerified(event){
    if(event.target.checked){
      this.userData.verified = 1;
    }
  }

}
