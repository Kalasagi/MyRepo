import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { TomeUI } from '../../model/tome-ui';

@Injectable()
export class TomeService {

  protected url : string = '/http://localhost:8080/tomes/';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<TomeUI[]> {
    return this.http.get<TomeUI[]>(this.url);
  }

  public getUpcoming(): Observable<TomeUI[]> {
    return this.http.get<TomeUI[]>(this.url + 'upcoming');
  }

  public getOne(id:number): Observable<TomeUI>
  {
    return this.http.get<TomeUI>(this.url + id);
  }

  public post(t:TomeUI): Observable<TomeUI>
  {
    return this.http.post(this.url, JSON.stringify(t));
  }


  public put(t:TomeUI): Observable<TomeUI>
  {
    return this.http.put(this.url + t.id, JSON.stringify(t));
  }
}
