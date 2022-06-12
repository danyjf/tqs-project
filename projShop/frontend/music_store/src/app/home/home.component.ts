import { Component, OnInit, EventEmitter } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

export class Product{
  constructor(
    public id: string,
    public name: string,
    public description: string, 
    public category: string,
    public imageURL: string,
    public price: string,
    public stock: string
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

  constructor(private breakpointObserver: BreakpointObserver, private router: Router, private httpClient: HttpClient) { }

  ngOnInit() {
    this.getProducts();
  } 

  searchText: string = "";


  onSearchTextEntered(searchValue: string){
    this.searchText = searchValue
  }

  navigateToProduct(id: string, title: string, description: string, category: string, price: string, image: string) {

    const params: NavigationExtras = {
      queryParams: {id: id, title: title, description: description, category: category, price: price, image: image},
    }
  
    this.router.navigate(['/product'], params);
  }

  getProducts(){
    this.httpClient.get<any>('http://localhost:7070/api/v1/products').subscribe(
      data => {
        this.products = data;
      }
    );
  }


}
