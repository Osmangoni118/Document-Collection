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
export class DocumenttypeService {

  constructor(private rest: RestService, private http: HttpClient) { }

  addDocumentType(documentType): Observable<any> {
    console.log(documentType);
    return this.http.post<any>(endpoint + 'api/document/types', JSON.stringify(documentType), httpOptions).pipe(
      tap((documentType) => alert(`added documentType`)),
      catchError(this.rest.handleError<any>('addDocumentType'))
    );
  }

  getDocumentTypeListByUserId(userId): Observable<any> {
    return this.http.get(endpoint + 'api/document/types?id=' + userId).pipe(
      map(this.rest.extractData));
  }

  getDocumentByTypeId(typeId): Observable<any> {
    return this.http.get(endpoint + 'api/document/documents?typeId=' + typeId).pipe(
      map(this.rest.extractData));
  }
}
