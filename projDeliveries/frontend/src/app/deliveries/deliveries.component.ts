import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { DELIVERIES } from '../mock-deliveries';

@Component({
    selector: 'app-deliveries',
    templateUrl: './deliveries.component.html',
    styleUrls: ['./deliveries.component.css']
})
export class DeliveriesComponent implements OnInit {
    deliveries = DELIVERIES;

    constructor(private router: Router) { }

    ngOnInit(): void {
    }

    navigateToDetails(id: number): void {
        console.log("navigate to details of " + id);
        // this.router.navigateByUrl("deliveries/id");
    }
}
