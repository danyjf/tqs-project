import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDelivery } from '../interfaces/delivery';
import { DeliveryService } from '../services/delivery.service';

@Component({
    selector: 'app-delivery-details',
    templateUrl: './delivery-details.component.html',
    styleUrls: ['./delivery-details.component.css']
})
export class DeliveryDetailsComponent implements OnInit {
    delivery?: IDelivery;

    constructor(private route: ActivatedRoute, private deliveryService: DeliveryService) { }

    ngOnInit(): void {
        this.getDelivery();
    }

    getDelivery(): void {
        const id = Number(this.route.snapshot.paramMap.get("id"));
        this.deliveryService.getDelivery(id)
            .subscribe(delivery => this.delivery = delivery);
    }
}
