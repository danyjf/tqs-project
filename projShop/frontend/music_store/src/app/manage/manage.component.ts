import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { NavigationExtras, ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Product } from '../home/home.component';


export class Order{
  constructor(
    public userid: number,
    public productid: number,
  ) {
    
  }
}
@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css']
})
export class ManageComponent {
  category: string = "";
  title : string = "";
  description : string = "";
  price : string = "";
  image : string = "";
  status : string = "Processing Payment";
  orders: Order[] = [];
  products: Product[] = [];

  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      this.getProducts();
      if (matches) {
        return this.products;
      }
      console.log(this.products);
      return this.products;
    })
  );
  cardsForHandset = [];
  cardsForWeb = [];

  isHandset: boolean = false;
  isHandsetObserver: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return true;
      }
      return false;
    })
  );

  constructor(private breakpointObserver: BreakpointObserver, private router: Router, private route: ActivatedRoute, private httpClient: HttpClient) {}

  ngOnInit() {
    this.getUserOrders();
    /**
    const category = this.route.snapshot.queryParamMap.get('category');
    if (category) {
      this.category = category;
    }
    
    const title = this.route.snapshot.queryParamMap.get('title');
    if (title) {
      this.title = title;
    }

    const description = this.route.snapshot.queryParamMap.get('description');
    if (description) {
      this.description = description;
    }

    const price = this.route.snapshot.queryParamMap.get('price');
    if (price) {
      this.price = price;
    }

    const image = this.route.snapshot.queryParamMap.get('image');
    if (image) {
      this.image = image;
    } */
  }
  getUserOrders(){
    this.httpClient.get<any>('http://localhost:7070/api/v1/user/orders/1').subscribe(
      data => {
        this.orders = data;
        this.getProducts();
      }
    );
  }
  getProducts(){
    this.httpClient.get<any>('http://localhost:7070/api/v1/products').subscribe(
      data => {
        const products = data;
        console.log(this.products);
        products.forEach( (product: Product) => {
          const id = product.id;
          this.orders.forEach( (order) => {
            if (String(order.productid) == id) {
              this.products.push(product);
            }
          });
      });
      console.log(this.products);
      }
    );
  }

}
