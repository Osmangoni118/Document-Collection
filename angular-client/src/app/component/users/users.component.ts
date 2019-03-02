import { Component, OnInit } from '@angular/core';
import { UserbasicService } from '../../service/userbasic.service';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: any = [];
  userbasic: any = {};

  constructor(private rest: UserbasicService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getUserBasicList();
  }

  getUserBasicList() {
    this.users = [];
    this.rest.getUsers().subscribe((data: {}) => {
      console.log(data);
      this.users = data;
    });
  }

  addUserBasic() {
    this.router.navigate(['/users/add-or-edit']);
  }

  addDocumentType(user) {
    let navigationExtras: NavigationExtras = {
      queryParams: { "userbasic": JSON.stringify(user) }
    };
    this.router.navigate(['/document/type/add'], navigationExtras);
  }
  showDocumentTypeList(user) {
    let navigationExtras: NavigationExtras = {
      queryParams: { "userbasic": JSON.stringify(user) }
    };
    this.router.navigate(['/document/type/list-by-userid'], navigationExtras);
  }
  showUserDocument(user) {
    let navigationExtras: NavigationExtras = {
      queryParams: { "userbasic": JSON.stringify(user) }
    };
    this.router.navigate(['/document/by/userid'], navigationExtras);
  }
  addUserDocument(userbasic) {
    let navigationExtras: NavigationExtras = {
      queryParams: { "userbasic": JSON.stringify(userbasic) }
    };
    this.router.navigate(['/document/add-or-edit'], navigationExtras);
  }

  addUserAddress(userbasic) {
    let navigationExtras: NavigationExtras = {
      queryParams: { "userbasic": JSON.stringify(userbasic) }
    };
    this.router.navigate(['/address/add-or-edit'], navigationExtras);
  }

  showUserFullInformation(userbasic) {
    let navigationExtras: NavigationExtras = {
      queryParams: { "userbasic": JSON.stringify(userbasic) }
    };
    this.router.navigate(['/users/user-full-information'], navigationExtras);
  }
}
