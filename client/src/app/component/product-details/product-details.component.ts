import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Product } from '../../model/Product';
import { ProductService } from '../../service/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {
  public product: Product = new Product(0, 0, 0, 0, 0, 0, 0, '', '', '', '', '', '', '', '', '');

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(
      params => this.productService
        .getProduct(+params.get('id'))
        .subscribe(
          data => {
            console.log('Product', data, +params.get('id'));
            this.product = data;
          },
          error => {
            console.log(error);
          }
        )
    );
  }
}
