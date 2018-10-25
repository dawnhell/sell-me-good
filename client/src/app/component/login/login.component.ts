import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  validateForm: FormGroup;
  isVisible = false;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }

    if (this.validateForm.valid) {
      this._loginService.login(this.validateForm.controls.email.value, this.validateForm.controls.password.value)

        .subscribe(
          data => {
            this._loginService.isLoggedIn = true;
            this.isVisible = false;
            this.validateForm.reset();

            localStorage.setItem('User', data['result']);
            localStorage.setItem('Token', data['token']);
          },
          error => {
            this._loginService.isLoggedIn = false;
            console.log(error);
          }
        );
    }
  }

  showModal(e): void {
    e.preventDefault();
    this.isVisible = true;
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  constructor(private _fb: FormBuilder, private _loginService: LoginService) {}

  ngOnInit(): void {
    this.validateForm = this._fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
      // remember: [true]
    });
  }
}
