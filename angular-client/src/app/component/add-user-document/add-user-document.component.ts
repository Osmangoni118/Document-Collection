import { Component, OnInit, Input } from '@angular/core';
import { DocumenttypeService } from '../../service/documenttype.service';
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
  typeId: any = '';


  @Input() userData = {
    id: '', documentValue: ''
  };

  constructor(private rest: DocumenttypeService, private propertyService: DocumentpropertyService,private route: ActivatedRoute, private router: Router) {
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

  // addUserDocument() {
  //   console.log('user basic ', this.userbasic);
  //   this.userData.userBasicDTO = JSON.parse(this.userbasic);
  //   console.log("document object : ", this.userData);
  //   this.rest.addOrEditUserDocument(this.userData).subscribe((result) => {
  //     this.router.navigate(['/users']);
  //   }, (err) => {
  //     console.log(err);
  //   });
  // }

  previousPage() {
    this.router.navigate(['/users']);
  }

  toggleVisibility(event, value) {
      console.log('value ', value);
    if (event.target.checked) {
      this.typeId = value;
      // this.userData.id = value;
      this.getDocumentPropertyList(value)
    }    

  }

}
