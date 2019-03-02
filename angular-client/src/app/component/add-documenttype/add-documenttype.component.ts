import { Component, OnInit, Input } from '@angular/core';

import { DocumenttypeService } from '../../service/documenttype.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-documenttype',
  templateUrl: './add-documenttype.component.html',
  styleUrls: ['./add-documenttype.component.css']
})
export class AddDocumenttypeComponent implements OnInit {
  userbasic: any = {};


  @Input() userData = {
    typeName: '', description: '', documentNo: 0, documentName: 0, verified: 0, documentValidity: 0, others: 0, basicDTO: {}
  };

  constructor(private rest: DocumenttypeService, private route: ActivatedRoute, private router: Router) {
    this.route.queryParams.subscribe(params => {
      console.log('param = ', params["userbasic"]);
      this.userbasic = params["userbasic"];
    });
  }

  ngOnInit() {
  }

  addDocumentType() {
    this.userData.basicDTO = JSON.parse(this.userbasic);
    console.log("document object : ", this.userData);
    this.rest.addDocumentType(this.userData).subscribe((result) => {
      console.log('result ', result);
      if (result != null) {
        alert('Data added successfully.');
        this.router.navigate(['/users']);
      } else {
        alert('Something wrong.');
      }
    }, (err) => {
      console.log(err);
    });
  }

  previousPage() {
    this.router.navigate(['/users']);
  }

  changeDocumentNo(event) {
    if (event.target.checked) {
      this.userData.documentNo = 1;
    }
    if (!event.target.checked) {
      this.userData.documentNo = 0;
    }
  }
  changeDocumentName(event) {
    if (event.target.checked) {
      this.userData.documentName = 1;
    }
    if (!event.target.checked) {
      this.userData.documentName = 0;
    }
  }
  changeVerified(event) {
    if (event.target.checked) {
      this.userData.verified = 1;
    }
    if (!event.target.checked) {
      this.userData.verified = 0;
    }
  }
  changeDocumentValidity(event) {
    if (event.target.checked) {
      this.userData.documentValidity = 1;
    }
    if (!event.target.checked) {
      this.userData.documentValidity = 0;
    }
  }
  changeOthers(event) {
    if (event.target.checked) {
      this.userData.others = 1;
    }
    if (!event.target.checked) {
      this.userData.others = 0;
    }
  }

}
