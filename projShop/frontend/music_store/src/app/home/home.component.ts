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
          { title: 'Queen - Made in Heaven', cols: 2, rows: 1, content: 'https://i.ytimg.com/vi/OLNz0313A4k/maxresdefault.jpg' },
          { title: 'Ukelele', cols: 1, rows: 1, content: 'https://images.ludimusic.com//Imagens/Catalogo/Produtos/217863/ukulele-fender-venice-soprano-black_1_331.jpg' },
          { title: 'Guns N Roses - Appetite for Destruction', cols: 1, rows: 2, content: 'https://whiplash.net/imagens_promo/gunsnroses_capa_appetitefordestruction.jpg' },
          { title: 'Guitarra Acústica', cols: 1, rows: 1, content: 'https://musicfactory.pt/MEDIA/32/IMAGE/PRODUCTS/YA/YA%20C40II.jpg' },
        ];
      }

      return [
        { title: 'Queen - Made in Heaven', cols: 2, rows: 1, content: 'https://i.ytimg.com/vi/OLNz0313A4k/maxresdefault.jpg' },
        { title: 'Ukelele', cols: 1, rows: 1, content: 'https://images.ludimusic.com//Imagens/Catalogo/Produtos/217863/ukulele-fender-venice-soprano-black_1_331.jpg' },
        { title: 'Guns N Roses - Appetite for Destruction', cols: 1, rows: 2, content: 'https://whiplash.net/imagens_promo/gunsnroses_capa_appetitefordestruction.jpg' },
        { title: 'Guitarra Acústica', cols: 1, rows: 1, content: 'https://musicfactory.pt/MEDIA/32/IMAGE/PRODUCTS/YA/YA%20C40II.jpg' },
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
