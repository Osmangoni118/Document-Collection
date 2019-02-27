import { Component, OnInit, Input } from '@angular/core';
import { DocumentpropertyService } from '../../service/documentproperty.service';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-add-document-property',
  templateUrl: './add-document-property.component.html',
  styleUrls: ['./add-document-property.component.css']
})
export class AddDocumentPropertyComponent implements OnInit {
  userbasic: any = {};
  typeDto: any = {};

  @Input() userData = {
    propertyType: '', propertyName: '', propertyLabel: '', documentTypeDTO: {}
  };

  constructor(private rest: DocumentpropertyService, private route: ActivatedRoute, private router: Router) {
    this.route.queryParams.subscribe(params => {
      console.log('param = ', params["typeDto"]);
      this.userbasic = params["userbasic"];
      this.typeDto = params["typeDto"];
    });
  }

  ngOnInit() {
  }

  addDocumentProperty() {
    this.userData.documentTypeDTO = JSON.parse(this.typeDto);
    console.log("document object : ", this.userData);
    this.rest.addDocumentProperty(this.userData).subscribe((result) => {
      console.log('result ', result);
      alert('Data successfull added.');
      let navigationExtras: NavigationExtras = {
        queryParams: { "typeDto": JSON.parse(this.typeDto),
        "userbasic": JSON.parse(this.userbasic) }
      };
      this.router.navigate(['/document/type/list-by-userid'], navigationExtras);
    }, (err) => {
      console.log(err);
    });
  }

  previousPage() {
    let navigationExtras: NavigationExtras = {
      queryParams: { "typeDto": JSON.parse(this.typeDto),
      "userbasic": JSON.parse(this.userbasic) }
    };
    this.router.navigate(['/document/type/list-by-userid'], navigationExtras);
  }

}
