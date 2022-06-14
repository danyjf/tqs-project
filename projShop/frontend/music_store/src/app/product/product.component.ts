import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { NavigationExtras, ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';



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

  constructor(private breakpointObserver: BreakpointObserver, private router: Router, private route: ActivatedRoute, private httpClient: HttpClient) {}

  ngOnInit() {
    const userid = sessionStorage.getItem('userid');
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
  }

  navigateToOrders(title: string, description: string, category: string, price: string, image: string) {

    const params: NavigationExtras = {
      queryParams: { title: title, description: description, category: category, price: price, image: image},
    }
  
    this.router.navigate(['/orders'], params);
  }

  createOrder(userID: string, productID: string){
    this.httpClient.post("http://localhost:7070/api/v1/order/"+userID+"/"+productID, {}).toPromise().then((response: any) => {console.log(response);});
    this.navigateToOrders(this.title, this.description, this.category, this.price, this.image);
  }
}
