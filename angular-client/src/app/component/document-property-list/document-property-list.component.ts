import { Component, OnInit } from '@angular/core';

import { DocumentpropertyService} from '../../service/documentproperty.service';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';
@Component({
  selector: 'app-document-property-list',
  templateUrl: './document-property-list.component.html',
  styleUrls: ['./document-property-list.component.css']
})
export class DocumentPropertyListComponent implements OnInit {

  propertyList: any = [];
  userbasic: any = {};
  typeDto: any = {};

  constructor(private rest: DocumentpropertyService, private route: ActivatedRoute, private router: Router) { 
    this.route.queryParams.subscribe(params => {
      console.log('param = ', params["userbasic"]);
      this.userbasic = params["userbasic"];
      this.typeDto = params["typeDto"];
    });
  }

  ngOnInit() {
    this.getDocumentPropertyList(JSON.parse(this.typeDto));
  } 

  getDocumentPropertyList(typeDto) {
    console.log('user basic id ', typeDto.id);
    this.propertyList = [];
    this.rest.getDocumentPropertyListByTypeId(typeDto.id).subscribe((data: {}) => {
      console.log('type list ',data);
      this.propertyList = data;
    });
  }

 
  addDocumentProperty() {
    let navigationExtras: NavigationExtras = {
      queryParams: { "typeDto": JSON.parse(this.typeDto),
      "userbasic": JSON.parse(this.userbasic) }
    };
    this.router.navigate(['/document/property/add'], navigationExtras);
  } 

  addDocumentPropertyFromList(typeDto) {
    let navigationExtras: NavigationExtras = {
      queryParams: { "typeDto": JSON.stringify(typeDto),
      "userbasic": JSON.parse(this.userbasic) }
    };
    this.router.navigate(['/document/property/add'], navigationExtras);
  }  

  previousPage() {
    let navigationExtras: NavigationExtras = {
      queryParams: { "userbasic": JSON.parse(this.userbasic)}
    };
    this.router.navigate(['/document/type/list-by-userid'], navigationExtras);
  }
}
