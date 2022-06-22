import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  session: boolean = true;
  public totalItem: number = 0;
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  ngOnInit() {
    this.session = (sessionStorage.getItem("user_id") === "-1" || sessionStorage.getItem("user_id") === null);
    this.cartService.getProducts().subscribe(resp => {
      this.totalItem = resp.length;
    })
  }

  constructor(private breakpointObserver: BreakpointObserver, private cartService: CartService) {}

}
