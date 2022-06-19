import { Component, OnInit } from '@angular/core';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  public product: any = [];
  public grandTotal !: number;
  public address: string = "";
  constructor(private cartService: CartService) { }

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
    if (this.address.length > 0){
      console.log(this.address)
    } 
  }

}
