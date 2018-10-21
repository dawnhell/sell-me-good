import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private _isLoggedIn = false;

  constructor(private _httpClient: HttpClient, private _router: Router) {}

  login (email: String, password: String) {
    return this._httpClient.post('https://localhost/api/login', { email, password });
  }

  logout () {
    localStorage.removeItem('User');
    localStorage.removeItem('Token');
    this.isLoggedIn = false;
    this._router.navigate(['/home']);
  }

  get isLoggedIn(): boolean {
    return this._isLoggedIn;
  }

  set isLoggedIn(value: boolean) {
    this._isLoggedIn = value;
  }
}
