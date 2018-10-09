import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators
} from "@angular/forms";

import { InfoService } from '../../service/info.service';
import { Info } from '../../model/Info';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {
  private info: Info;
  private isEditing: boolean = false;
  private editInfoForm: FormGroup;

  constructor(private _infoService: InfoService, private _fb: FormBuilder) { }

  ngOnInit() {
    this._infoService.getInfo().subscribe(
      data => {
        this.info = new Info(data['about'], data['author'], data['foundationDate'], data['shopName']);

        this.editInfoForm = this._fb.group({
          about: [data['about'], [ Validators.required ]],
          author: [data['author'], [ Validators.required ]],
          foundationDate: [data['foundationDate'], [ Validators.required ]],
          shopName: [data['shopName'], [ Validators.required ]],
        });
      },
      error => {
        console.log(error);
      }
    );
  }

  submitForm(): void {
    for (const i in this.editInfoForm.controls) {
      this.editInfoForm.controls[i].markAsDirty();
      this.editInfoForm.controls[i].updateValueAndValidity();
    }

    this.isEditing = !this.isEditing;

    this._infoService.saveInfo(this.editInfoForm.value)
      .subscribe(
        data => this.info = new Info(data['about'], data['author'], data['foundationDate'], data['shopName']),
        error => {
          console.log(error);
        }
      );
  }
}
