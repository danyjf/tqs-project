import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Delivery } from '../delivery';
import { DeliveryService } from '../delivery.service';

@Component({
    selector: 'app-deliveries',
    templateUrl: './deliveries.component.html',
    styleUrls: ['./deliveries.component.css']
})
export class DeliveriesComponent implements OnInit {
    deliveries: Delivery[] = [];

    constructor(private router: Router, private deliveryService: DeliveryService) { }

    ngOnInit(): void {
        this.getPendingDeliveries();
    }

    getPendingDeliveries(): void {
        this.deliveryService.getPendingDeliveries()
            .subscribe(deliveries => this.deliveries = deliveries);
    }

    navigateToDetails(id: number): void {
        this.router.navigateByUrl(`deliveries/${id}`);
    }
}
