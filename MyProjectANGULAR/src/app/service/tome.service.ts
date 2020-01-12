import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Injectable()
export class TomeService {

  protected url : string = '/http://localhost:8080/tomes/';

  constructor(private http: HttpClient, public sanitizer: DomSanitizer) {}

  getAll() {
    return this.http.get<any[]>(this.url).pipe(map(data => data));
  }

  getUpcoming() {
    return this.http.get<any>(this.url + 'upcoming').pipe(map(data => data));
  }
}
