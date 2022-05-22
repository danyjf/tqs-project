import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css']
})
export class ManageComponent {
  /** Based on the screen size, switch from standard to one column per row */
  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title: 'Product 1', stock: '5', price: 5, content: "Description"},
          { title: 'Product 2', stock: '3', price: 5, content: "Description" },
          { title: 'Product 3', stock: '2', price: 5, content: "Description" },
          { title: 'Product 4', stock: 'Not', price: 5, content: "Description" }
        ];
      }

      return [
        { title: 'Product 1', stock: '5', price: 5, content: "Description" },
        { title: 'Product 2', stock: '3', price: 5, content: "Description" },
        { title: 'Product 3', stock: '2', price: 5, content: "Description" },
        { title: 'Product 4', stock: 'Not', price: 5, content: "Description" }
      ];
    })
  );

  constructor(private breakpointObserver: BreakpointObserver) {}
}
