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
export class UserbasicService {

  constructor(private rest:RestService, private http: HttpClient) { }

  
  getUsers(): Observable<any> {
    return this.http.get(endpoint + 'users').pipe(
      map(this.rest.extractData));
  }

  getUserFullInformation(userbasic): Observable<any> {
    console.log('service ', userbasic);
    return this.http.post<any>(endpoint + 'users/' + 'user-full-information', JSON.stringify(userbasic), httpOptions).pipe(
      map(this.rest.extractData));
  }

  addOrEditUserBasic(userbasic): Observable<any> {
    console.log(userbasic);
    return this.http.post<any>(endpoint + 'users/' + 'add-or-edit', JSON.stringify(userbasic), httpOptions).pipe(
      tap((userbasic) => console.log(`added userbasic w/ id=${userbasic.userBasicID}`)),
      catchError(this.rest.handleError<any>('addOrEditUserBasic'))
    );
  }

}
