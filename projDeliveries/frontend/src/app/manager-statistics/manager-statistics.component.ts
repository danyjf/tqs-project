import { Component, OnInit } from '@angular/core';

import { DeliveryService } from '../delivery.service';
import { Delivery } from '../delivery';
import { STORES } from '../stores';

@Component({
    selector: 'app-manager-statistics',
    templateUrl: './manager-statistics.component.html',
    styleUrls: ['./manager-statistics.component.css']
})
export class ManagerStatisticsComponent implements OnInit {
    stores = STORES;
    deliveries: Delivery[] = [];
    delayed: string = "all";
    store: string = "all";
    status: string = "all";

    constructor(private deliveryService: DeliveryService) { }

    ngOnInit(): void {
        this.getFilteredDeliveries();
    }

    getFilteredDeliveries(): void {
        this.deliveryService.getFilteredDeliveries(this.delayed, this.store, this.status)
            .subscribe(deliveries => this.deliveries = deliveries);
    }
}
