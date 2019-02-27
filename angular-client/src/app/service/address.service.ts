import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import {RestService} from '../rest.service';

const endpoint = 'http://localhost:8080/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  constructor(private rest:RestService, private http: HttpClient) { }

  addOrEditAddress(address): Observable<any> {
    console.log(address);
    return this.http.post<any>(endpoint + 'address/' + 'add-or-edit', JSON.stringify(address), httpOptions).pipe(
      tap((address) => console.log(`added address`)),
      catchError(this.rest.handleError<any>('addOrEditAddress'))
    );
  }

  getAddressListByUserBasic(userbasic): Observable<any> {
    return this.http.post<any>(endpoint + 'address/' + 'list-by-user', JSON.stringify(userbasic), httpOptions).pipe(
      map(this.rest.extractData));
  }
}
