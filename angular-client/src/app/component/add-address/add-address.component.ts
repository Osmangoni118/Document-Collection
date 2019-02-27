import { Component, OnInit, Input } from '@angular/core';
import { AddressService } from '../../service/address.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css']
})
export class AddAddressComponent implements OnInit {

  userbasic: any = {};

  @Input() userData = {
    addressType: '', district: '', postOffice: '', thana: '',
    village: '', zipCode: '', userBasicDTO: {}
  };

  constructor(private rest: AddressService, private route: ActivatedRoute, private router: Router) {
    this.route.queryParams.subscribe(params => {
      console.log('param = ', params["userbasic"]);
      this.userbasic = params["userbasic"];
    });
  }

  ngOnInit() {
  }

  addUserAddress() {
    this.userData.userBasicDTO = JSON.parse(this.userbasic);
    console.log("document object : ", this.userData);
    this.rest.addOrEditAddress(this.userData).subscribe((result) => {
      this.router.navigate(['/users']);
    }, (err) => {
      console.log(err);
    });
  }

  previousPage() {
    this.router.navigate(['/users']);
  }

  
  toggleVisibility(event, value) {

    if (event.target.checked) {
      this.userData.addressType = value;
    }

    if (!event.target.checked) {
      this.userData.addressType = '';
    }

  }

}
