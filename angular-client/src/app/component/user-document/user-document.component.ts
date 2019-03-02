import { Component, OnInit } from '@angular/core';
import { DocumenttypeService } from '../../service/documenttype.service';
import { UserdocumentService } from '../../service/userdocument.service';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-user-document',
  templateUrl: './user-document.component.html',
  styleUrls: ['./user-document.component.css']
})
export class UserDocumentComponent implements OnInit {
  documentList: any = [];
  userbasic: any = {};
  user: any = {};

  constructor(private document: UserdocumentService, private rest: DocumenttypeService, private route: ActivatedRoute, private router: Router) {
    this.route.queryParams.subscribe(params => {
      console.log('param = ', params["userbasic"]);
      this.userbasic = params["userbasic"];
    });
  }

  ngOnInit() {
    this.getDocumentList(JSON.parse(this.userbasic));
    this.user = JSON.parse(this.userbasic);
    console.log('user ', this.user);
  }

  getDocumentList(userBasic) {
    this.documentList = [];
    console.log('user id ', userBasic.userBasicID);
    this.document.getDocumentListByUserId(userBasic).subscribe((data: {}) => {
      console.log('document list ', data);
      this.documentList = data;
    });
  }

  previousPage() {
    this.router.navigate(['/users']);
  }
}
