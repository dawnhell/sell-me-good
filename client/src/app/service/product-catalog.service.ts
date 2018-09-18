import { Injectable } from '@angular/core';

import { NgxSoapService, ISoapMethod, Client, ISoapMethodResponse } from 'ngx-soap';


@Injectable({
  providedIn: 'root'
})
export class ProductCatalogService {
  client: Client;
  xmlResponse: string;

  constructor(private soap: NgxSoapService) {
    this.soap.createClient('assets/productCatalogWSDL.xml')
      .then(client => {
        console.log('Client', client);
        this.client = client;
      })
      .catch(err => console.log('Error', err));
  }

  getProductCategories () {
    (<any>this.client).wsdl.services.ProductCatalogService.ports.ProductCatalogPort.binding.methods.getProductCategories().subscribe(
      (res: ISoapMethodResponse) => {
        console.log('method response', res);
        // this.xmlResponse = res.xml;
        // this.message = res.result.SubtractResult;
      },
      err => console.log(err)
    );

    // this.client.call('getShopInfo', {property: 'shopName'}).subscribe(res => {
    //   this.xmlResponse = res.responseBody;
    //   console.log(res);
    // }, err => console.log(err));


  }
}
