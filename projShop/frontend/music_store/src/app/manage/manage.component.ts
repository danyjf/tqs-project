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
    public products: Product[],
    public productid: number,
    public status: string
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
  status : string = "";
  nProducts: number = 0;
  orders: Order[] = [];
  products: Product[] = [];
  userid: string = "-1";

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
    const id = sessionStorage.getItem('user_id');
    if (id != null) {
      this.userid = id
      this.getUserOrders();
    }
  }

  getUserOrders(){
    console.log('http://localhost:7070/api/v1/user/orders/' + this.userid)
    this.httpClient.get<any>('http://localhost:7070/api/v1/user/orders/' + this.userid).subscribe(
      data => {
        this.orders = data;
        console.log(this.orders);
        this.nProducts = this.orders.length;
      }
    );
  }

  getProducts(){
    this.httpClient.get<any>('http://localhost:7070/api/v1/products').subscribe(
      data => {
        const products = data.content;
        products.forEach( (product: Product) => {
          const id = product.id;
          this.orders.forEach( (order) => {
            if (String(order.productid) == id) {
              product.status = order.status.toString();
              this.products.push(product);
            }
          });
      });
      console.log(this.products);
      }
    );
  }

}
