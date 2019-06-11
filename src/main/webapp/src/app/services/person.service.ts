import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Page } from '../models/page';
import { Person } from '../models/person';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({ providedIn: 'root' })
export class PersonService {

  private listUrl = '/dashboard/person/list';
  private searchUrl = '/dashboard/person/search';

  constructor(private http: HttpClient) {
    //
  }

  list(pageIndex: number, pageSize: number): Observable<Page<Person>> {
    return this.http.get<Page<Person>>(this.listUrl + "?page=" + pageIndex + "&size=" + pageSize)
      .pipe(
        tap(_ => this.log("Done! List of Persons [" + pageIndex + ", " + pageSize + "]")),
        catchError(this.handleError<Page<Person>>('listPersons', {} as any))
      );
  }

  search(query: string): Observable<Page<Person>> {
    return this.http.get<Page<Person>>(this.searchUrl + "?query=" + query + "&size=" + 1000)
      .pipe(
        tap(_ => this.log("Done! Search Persons [" + query + "]")),
        catchError(this.handleError<Page<Person>>('listPersons', {} as any))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  private log(message: string) {
    console.log(message);
  }

}