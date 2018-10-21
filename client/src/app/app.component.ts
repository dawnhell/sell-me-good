import { Component, TemplateRef, ViewChild } from '@angular/core';

import { LoginService } from './service/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  isCollapsed = false;
  triggerTemplate = null;
  localStorage = localStorage;
  @ViewChild('trigger') customTrigger: TemplateRef<void>;

  constructor (public loginService: LoginService) {}

  logout (e) {
    e.preventDefault();
    this.loginService.logout();
  }
}
