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
export class DocumentpropertyService {

  constructor(private rest: RestService, private http: HttpClient) { }

  addDocumentProperty(documentProperty): Observable<any> {
    console.log(documentProperty);
    return this.http.post<any>(endpoint + 'api/document/properties', JSON.stringify(documentProperty), httpOptions).pipe(
      tap((documentProperty) => console.log(`added document property`)),
      catchError(this.rest.handleError<any>('addDocumentProperty'))
    );
  }

  getDocumentPropertyListByTypeId(typeId): Observable<any> {
    return this.http.get(endpoint + 'api/document/properties?id=' + typeId).pipe(
      map(this.rest.extractData));
  }
}
