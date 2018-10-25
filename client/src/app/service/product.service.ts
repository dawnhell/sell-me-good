import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Product } from '../model/Product';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private _httpClient: HttpClient) {}

  getProducts (): Observable<Array<Product>> {
    return this._httpClient.get<Array<Product>>('http://localhost:8080/sellmegood/api/products');
  }

  getProduct (id: number): Observable<Product> {
    return this._httpClient.get<Product>('http://localhost:8080/sellmegood/api/product/' + id);
  }
}