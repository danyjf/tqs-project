import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../service/cart.service';
import { SHOP_API_URL, DELIVERIES_API_URL } from '../globals';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  public product: any = [];
  public grandTotal !: number;
  public address: string = "";
  public name: string = "";
  public note: string = "";
  public phone: string = "";
  public products: string = "";
  closeResult = '';

  constructor(private cartService: CartService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.cartService.getProducts().subscribe(resp => {
      this.product = resp;
      this.grandTotal = this.cartService.getTotalPrice();
    })
  }

  removeItem(product: any) {
    this.cartService.removeCartItem(product);
  }

  emptyCart() {
    this.cartService.removeAllCart();
  }

  checkout() {
    if (this.address.length > 0 && this.phone.length > 0 && this.name.length > 0) {
      console.log(this.address)
      this.products = "";
      this.product.forEach((prod: { productID: string; }) => {
        this.products += prod.productID + "-";
      });
      this.products = this.products.slice(0, -1);
      this.httpClient.post(`${SHOP_API_URL}/api/v1/order/${sessionStorage.getItem("user_id")}?products=${this.products}`, {}).toPromise().then((response: any) => {
        console.log(response);

        const order_id = response.id

        this.httpClient.post(`${DELIVERIES_API_URL}/order`, {
          "orderId": order_id,
          "clientName": this.name,
          "deliveryAddress": this.address,
          "clientPhone": this.phone,
          "storeIdentifier": "music_shop",
          "storePhone": "912345678",
          "orderNote": this.note,
          "orderTime": this.formatDate(new Date())
        }).toPromise().then((response: any) => {
          console.log(response);
          this.cartService.removeAllCart();
          
          this.router.navigate(['/orders']);

      })

      })
    } else {
      confirm("Please fill in all the fields");
    }
  }

  getTotalPrice() : number {
    return this.cartService.getTotalPrice();
  }

  padTo2Digits(num: number) {
    return num.toString().padStart(2, '0');
  }
  
  formatDate(date: Date) {
    return (
      [
        date.getFullYear(),
        this.padTo2Digits(date.getMonth() + 1),
        this.padTo2Digits(date.getDate()),
      ].join('-') +
      ' ' +
      [
        this.padTo2Digits(date.getHours()),
        this.padTo2Digits(date.getMinutes()),
        this.padTo2Digits(date.getSeconds()),
      ].join(':')
    );
  }

}
