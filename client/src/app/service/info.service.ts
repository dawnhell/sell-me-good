import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Info } from '../model/Info';

@Injectable({
  providedIn: 'root'
})
export class InfoService {
  constructor(private _httpClient: HttpClient) { }

  getInfo (): Observable<Info> {
    return this._httpClient.get<Info>('http://localhost:8080/sellmegood/api/info');
  }

  saveInfo (info): Observable<Info> {
    return this._httpClient.post<Info>('http://localhost:8080/sellmegood/api/info', info);
  }
}

