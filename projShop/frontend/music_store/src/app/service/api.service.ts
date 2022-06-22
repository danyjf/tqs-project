import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { SHOP_API_URL } from '../globals';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http : HttpClient) { }

  getProducts() {
    return this.http.get<any>(SHOP_API_URL + '/api/v1/products')
    .pipe(map((response : any) => { return response; }))
  }
}
