import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { NavigationExtras, ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css']
})
export class ManageComponent {
  category: string = "";
  title : string = "";
  description : string = "";
  price : string = "";
  image : string = "";
  status : string = "Processing Payment";
  constructor(private breakpointObserver: BreakpointObserver, private router: Router, private route: ActivatedRoute,) {}

  ngOnInit() {
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
}
