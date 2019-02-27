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
    typeName: '', description: '', storageAddress: '', multipleDocument: '', basicDTO: {}
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
      alert('Data successfull added.');
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
      this.userData.multipleDocument = value;
    }
  }

}
