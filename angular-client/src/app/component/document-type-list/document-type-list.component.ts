import { Component, OnInit } from '@angular/core';

import { DocumenttypeService } from '../../service/documenttype.service';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-document-type-list',
  templateUrl: './document-type-list.component.html',
  styleUrls: ['./document-type-list.component.css']
})
export class DocumentTypeListComponent implements OnInit {

  typeList: any = [];
  userbasic: any = {};

  constructor(private rest: DocumenttypeService, private route: ActivatedRoute, private router: Router) {
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

  addDocumentType() {
    let navigationExtras: NavigationExtras = {
      queryParams: { "userbasic": JSON.stringify(this.userbasic) }
    };
    this.router.navigate(['/document/type/add'], navigationExtras);
  }
  addDocumentProperty(typeDto) {
    let navigationExtras: NavigationExtras = {
      queryParams: {
        "typeDto": JSON.stringify(typeDto),
        "userbasic": JSON.stringify(this.userbasic)
      }
    };
    this.router.navigate(['/document/property/add'], navigationExtras);
  }

  showProperties(typeDto) {
    let navigationExtras: NavigationExtras = {
      queryParams: {
        "typeDto": JSON.stringify(typeDto),
        "userbasic": JSON.stringify(this.userbasic)
      }
    };
    this.router.navigate(['/document/property/list-by-typeid'], navigationExtras);
  }

  previousPage() {
    this.router.navigate(['/users']);
  }
}
