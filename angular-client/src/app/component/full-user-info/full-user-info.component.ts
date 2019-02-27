import { Component, OnInit } from '@angular/core';
import { UserbasicService } from '../../service/userbasic.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-full-user-info',
  templateUrl: './full-user-info.component.html',
  styleUrls: ['./full-user-info.component.css']
})
export class FullUserInfoComponent implements OnInit {
  userbasic: any = {};
  userFullInfo: any = {};

  constructor(private rest: UserbasicService, private route: ActivatedRoute, private router: Router) {
    this.route.queryParams.subscribe(params => {
      console.log('param = ', params["userbasic"]);
      this.userbasic = params["userbasic"];
    });
  }

  ngOnInit() {
    this.getUserFullInformation();
  }
  
  getUserFullInformation() {
    this.userFullInfo = {};
    this.rest.getUserFullInformation(JSON.parse(this.userbasic)).subscribe((data: {}) => {
      console.log('user full informantion',data);
      this.userFullInfo = data;
      console.log('full user ', this.userFullInfo);
    });
  }

  previousPage() {
    this.router.navigate(['/users']);
  }

}
