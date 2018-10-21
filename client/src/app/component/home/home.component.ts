import { Component, OnInit } from '@angular/core';
import { ProductCatalogService } from '../../service/product-catalog.service';
import { ProductService } from "../../service/product.service";
import { Product } from "../../model/Product";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public productList: Product[] = [];

  constructor(private _productCatalogService: ProductCatalogService, private _productService: ProductService) { }

  ngOnInit() {
    this._productService.getProducts().subscribe(
      data => {
        this.productList = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  onBtnClick () {
    this._productCatalogService.getProductCategories();
  }

}
