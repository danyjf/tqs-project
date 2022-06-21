import { Component, OnInit, EventEmitter } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { loggedIn } from '../app.component';
import { ApiService } from '../service/api.service';
import { CartService } from '../service/cart.service';

export class Product{
  constructor(
    public id: string,
    public name: string,
    public description: string, 
    public category: string,
    public imageURL: string,
    public price: string,
    public stock: string,
    public status: string
  ) {
    
  }
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  products: Product[] | undefined;

  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
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

  constructor(private breakpointObserver: BreakpointObserver, private api: ApiService, private router: Router, private httpClient: HttpClient, private cartService: CartService) { }

  ngOnInit() {
    console.log(sessionStorage.getItem("user_id"));
    this.api.getProducts().subscribe(resp => {
      this.products = resp.content;
    })
  } 

  searchText: string = "";

  onSearchTextEntered(searchValue: string){
    this.searchText = searchValue
  }

  navigateToProduct(id: string, title: string, description: string, category: string, price: string, image: string, stock: string) {

    const params: NavigationExtras = {
      queryParams: {id: id, title: title, description: description, category: category, price: price, image: image, stock: stock},
    }
  
    this.router.navigate(['/product'], params);
  }

  addToCart(id: string,title: string, description: string, category: string, price: string, image: string){
    const userID = sessionStorage.getItem('user_id')
    if(userID !== "-1" && userID !== null) {
      const product: Product = new Product((Math.floor(Math.random() * (100000000 - 0 + 1)) + 0).toString(), title, description, category, image, price, "NA", "Pending");
      Object.assign(product, {quantity: 1, totalprice: price, productID: id});
      this.cartService.addToCart(product);
    } else{
      this.router.navigate(['/login']);
    }
  }


}
