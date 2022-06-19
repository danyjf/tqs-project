import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { NavigationExtras, ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Product } from '../home/home.component';
import { CartService } from '../service/cart.service';




@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  id: string = "";
  category: string = "";
  title : string = "";
  description : string = "";
  price : string = "";
  image : string = "";
  userid: string = "-1";
  stock: string = "";


  constructor(private breakpointObserver: BreakpointObserver, private cartService: CartService, private router: Router, private route: ActivatedRoute, private httpClient: HttpClient) {}

  ngOnInit() {
    const userid = sessionStorage.getItem('user_id');
    if (userid != null) {
      this.userid = userid;
    }
    const id = this.route.snapshot.queryParamMap.get('id');
    if (id) {
      this.id = id;
    }
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
    }
    
    const stock = this.route.snapshot.queryParamMap.get('stock');
    if (stock) {
      this.stock = stock;
    }
  }

  navigateToOrders(title: string, description: string, category: string, price: string, image: string) {

    const params: NavigationExtras = {
      queryParams: { title: title, description: description, category: category, price: price, image: image},
    }
  
    this.router.navigate(['/orders'], params);
  }

  addToCart(title: string, description: string, category: string, price: string, image: string){
    const product: Product = new Product("temp", title, description, category, image, price, "NA", "Pending");
    Object.assign(product, {quantity: 1, totalprice: price});
    this.cartService.addToCart(product);
  }

  createOrder(productID: string){
    const userID = sessionStorage.getItem('user_id')
    if(userID !== "-1" && userID !== null) {
      const buy = confirm("Are you sure you want to buy this product?");
      if (buy) {
        const address = prompt("Please enter the delivery address: ");
        console.log(address);
        console.log("userID: " + userID)
          if (this.stock !== "0"){
              this.httpClient.post("http://localhost:7070/api/v1/order/"+userID+"/"+productID, {}).toPromise().then((response: any) => {console.log(response);
              this.navigateToOrders(this.title, this.description, this.category, this.price, this.image);
            });
          }
    }
  } else{
    this.router.navigate(['/login']);
  }
}
}
