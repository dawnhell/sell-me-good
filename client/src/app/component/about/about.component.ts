import { Component, OnInit } from '@angular/core';
import { InfoService } from "../../service/info.service";
import { Info } from "../../model/Info";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {
  private info: Info;

  constructor(private _infoService: InfoService) { }

  ngOnInit() {
    this._infoService.getInfo().subscribe(
      data => {
        console.log(data);
        this.info = new Info(data['about'], data['author'], data['foundationDate'], data['shopName'])
      },
      error => {
        console.log(error);
      }
    );
  }

}
