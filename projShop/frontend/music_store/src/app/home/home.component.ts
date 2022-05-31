import { Component } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
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
          { title: 'Acoustic Guitar', description: 'An acoustic guitar is a musical instrument in the string family.', category: 'Musical Instrument', price: '80', cols: 2, rows: 1, image: 'https://musicfactory.pt/MEDIA/32/IMAGE/PRODUCTS/YA/YA%20C40II.jpg' },
          { title: 'Ukelele', description: 'The ukulele is a member of the lute family of instruments of Portuguese origin and popularized in Hawaii.', category: 'Musical Instrument', price: '50', cols: 1, rows: 1, image: 'https://images.ludimusic.com//Imagens/Catalogo/Produtos/217863/ukulele-fender-venice-soprano-black_1_331.jpg' },
          { title: 'Guns N Roses - Appetite for Destruction', description: 'Appetite for Destruction is the debut studio album by American hard rock band Guns N Roses. It was released on July 21, 1987, by Geffen Records.', category: 'Vinyl Disc', price: '15', cols: 1, rows: 2, image: 'https://whiplash.net/imagens_promo/gunsnroses_capa_appetitefordestruction.jpg' },
          { title: 'Queen - Made in Heaven', description: 'Made In Heaven is the fifteenth and final studio album by British rock band Queen, released on 6 November 1995, and is a posthumous tribute to lead singer Freddie Mercury.', category: 'Vinyl Disc', price: '20', cols: 1, rows: 1, image: 'https://i.ytimg.com/vi/OLNz0313A4k/maxresdefault.jpg' },
        ];
      }
      return [
        { title: 'Acoustic Guitar', description: 'An acoustic guitar is a musical instrument in the string family.', category: 'Musical Instrument', price: '80', cols: 2, rows: 1, image: 'https://musicfactory.pt/MEDIA/32/IMAGE/PRODUCTS/YA/YA%20C40II.jpg' },
        { title: 'Ukelele', description: 'The ukulele is a member of the lute family of instruments of Portuguese origin and popularized in Hawaii.', category: 'Musical Instrument', price: '50', cols: 1, rows: 1, image: 'https://images.ludimusic.com//Imagens/Catalogo/Produtos/217863/ukulele-fender-venice-soprano-black_1_331.jpg' },
        { title: 'Guns N Roses - Appetite for Destruction', description: 'Appetite for Destruction is the debut studio album by American hard rock band Guns N Roses. It was released on July 21, 1987, by Geffen Records.', category: 'Vinyl Disc', price: '15', cols: 1, rows: 2, image: 'https://whiplash.net/imagens_promo/gunsnroses_capa_appetitefordestruction.jpg' },
        { title: 'Queen - Made in Heaven', description: 'Made In Heaven is the fifteenth and final studio album by British rock band Queen, released on 6 November 1995, and is a posthumous tribute to lead singer Freddie Mercury.', category: 'Vinyl Disc', price: '20', cols: 1, rows: 1, image: 'https://i.ytimg.com/vi/OLNz0313A4k/maxresdefault.jpg' },
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

  constructor(private breakpointObserver: BreakpointObserver, private router: Router) { }
  navigateToProduct(title: string, description: string, category: string, price: string, image: string) {

    const params: NavigationExtras = {
      queryParams: { title: title, description: description, category: category, price: price, image: image},
    }
  
    this.router.navigate(['/product'], params);
  }


}
