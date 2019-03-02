import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UsersComponent } from './component/users/users.component';
import { AddUserComponent } from './component/add-user/add-user.component';
import { FullUserInfoComponent } from './component/full-user-info/full-user-info.component';
import { AddAddressComponent } from './component/add-address/add-address.component';
import { AddUserDocumentComponent } from './component/add-user-document/add-user-document.component';
import { DocumentByuserComponent } from './component/document-byuser/document-byuser.component';
import { DocumentBytypeComponent } from './component/document-bytype/document-bytype.component';
import { AddressByuserComponent } from './component/address-byuser/address-byuser.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AddDocumenttypeComponent } from './component/add-documenttype/add-documenttype.component';
import { AddDocumentPropertyComponent } from './component/add-document-property/add-document-property.component';
import { DocumentTypeListComponent } from './component/document-type-list/document-type-list.component';
import { DocumentPropertyListComponent } from './component/document-property-list/document-property-list.component';
import { UserDocumentComponent } from './component/user-document/user-document.component';


const appRoutes: Routes = [
  {
    path: 'users',
    component: UsersComponent,
    data: { title: 'User List' }
  },
  {
    path: 'users/user-full-information',
    component: FullUserInfoComponent,
    data: { title: 'User Details' }
  },
  {
    path: 'users/add-or-edit',
    component: AddUserComponent,
    data: { title: 'Add User' }
  },
  {
    path: 'address/add-or-edit',
    component: AddAddressComponent,
    data: { title: 'Add User Address' }
  },
  {
    path: 'address/list-by-user',
    component: AddressByuserComponent,
    data: { title: 'Address List By User' }
  },
  {
    path: 'document/add-or-edit',
    component: AddUserDocumentComponent,
    data: { title: 'Add User Document' }
  },
  {
    path: 'document/list-by-user',
    component: DocumentByuserComponent,
    data: { title: 'Document List By User' }
  },
  {
    path: 'document/by/userid',
    component: UserDocumentComponent,
    data: { title: 'Document List By User' }
  },
  {
    path: 'document/list-by-document-type/:documentType',
    component: DocumentBytypeComponent,
    data: { title: 'Document List By Type' }
  },
  {
    path: 'document/type/list-by-userid',
    component: DocumentTypeListComponent,
    data: { title: 'Document Type List By User' }
  },
  {
    path: 'document/type/add',
    component: AddDocumenttypeComponent,
    data: { title: 'Add Document Type By User' }
  },
  {
    path: 'document/property/list-by-typeid',
    component: DocumentPropertyListComponent,
    data: { title: 'Document Type List By User' }
  },
  {
    path: 'document/property/add',
    component: AddDocumentPropertyComponent,
    data: { title: 'Add Document Type By User' }
  },
  { path: '',
    redirectTo: '/users',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    AddUserComponent,
    FullUserInfoComponent,
    AddAddressComponent,
    AddUserDocumentComponent,
    DocumentByuserComponent,
    DocumentBytypeComponent,
    AddressByuserComponent,
    AddDocumenttypeComponent,
    AddDocumentPropertyComponent,
    DocumentTypeListComponent,
    DocumentPropertyListComponent,
    UserDocumentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
