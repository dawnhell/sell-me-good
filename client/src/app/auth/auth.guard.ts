import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

import { Observable } from 'rxjs';

import { LoginService } from '../service/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor (private _loginService: LoginService, private _router: Router) {}

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return this.checkLogin(state.url);
  }

  checkLogin(url: string): boolean {
    // this._loginService.redirectUrl = url;

    this._router.navigate(['/home']);
    return this._loginService.isLoggedIn;
  }
}
