import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { RestService } from '../rest.service';

const endpoint = 'http://localhost:8080/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserdocumentService {

  constructor(private rest: RestService, private http: HttpClient) { }

  addOrEditUserDocument(userDocument): Observable<any> {
    console.log(userDocument);
    return this.http.post<any>(endpoint + 'document/' + 'add-or-edit', JSON.stringify(userDocument), httpOptions).pipe(
      tap((userDocument) => console.log(`added userDocument`)),
      catchError(this.rest.handleError<any>('addOrEditUserDocument'))
    );
  }

  getUserDocumentListByUserBasic(userbasic): Observable<any> {
    return this.http.post<any>(endpoint + 'document/' + 'list-by-user', JSON.stringify(userbasic), httpOptions).pipe(
      map(this.rest.extractData));
  }

  getUserDocumentListByDocumentType(documentType): Observable<any> {
    return this.http.get(endpoint + 'document/' + 'list-by-document-type/' + documentType).pipe(
      map(this.rest.extractData));
  }

}
