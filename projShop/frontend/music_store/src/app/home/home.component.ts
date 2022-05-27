import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  /** Based on the screen size, switch from standard to one column per row */
  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title: 'Product 1', cols: 2, rows: 1, content: 'Description' },
          { title: 'Product 2', cols: 1, rows: 1, content: 'Description' },
          { title: 'Product 3', cols: 1, rows: 2, content: 'Description' },
          { title: 'Product 4', cols: 1, rows: 1, content: 'Description' }
        ];
      }

      return [
        { title: 'Product 1', cols: 2, rows: 1, content: 'Description' },
        { title: 'Product 2', cols: 1, rows: 1, content: 'Description' },
        { title: 'Product 3', cols: 1, rows: 2, content: 'Description' },
        { title: 'Product 4', cols: 1, rows: 1, content: 'Description' }
      ];
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

  constructor(private breakpointObserver: BreakpointObserver,) { }


}
