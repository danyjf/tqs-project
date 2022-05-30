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
          { title: 'Ukelele', status: 'Processing Payment', price: 5, image: 'https://images.ludimusic.com//Imagens/Catalogo/Produtos/217863/ukulele-fender-venice-soprano-black_1_331.jpg'},

        ];
      }

      return [
        { title: 'Ukelele', status: 'Processing Payment', price: 5, image: 'https://images.ludimusic.com//Imagens/Catalogo/Produtos/217863/ukulele-fender-venice-soprano-black_1_331.jpg'},
      ];
    })
  );

  constructor(private breakpointObserver: BreakpointObserver) {}
}
