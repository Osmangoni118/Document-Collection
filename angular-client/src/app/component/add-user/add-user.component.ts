import { Component, OnInit, Input } from '@angular/core';
import {UserbasicService} from '../../service/userbasic.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  @Input() userData = { firstName:'', lastName: '', email: '', mobileNo: '' };

  constructor(public rest:UserbasicService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  addUserBasic() {
    this.rest.addOrEditUserBasic(this.userData).subscribe((result) => {
      this.router.navigate(['/users']);
    }, (err) => {
      console.log(err);
    });
  }

  previousPage() {
    this.router.navigate(['/users']);
  }

}
