import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { IDelivery } from '../interfaces/delivery';
import { DeliveryService } from '../services/delivery.service';

@Component({
    selector: 'app-delivery-details',
    templateUrl: './delivery-details.component.html',
    styleUrls: ['./delivery-details.component.css']
})
export class DeliveryDetailsComponent implements OnInit {
    delivery?: IDelivery;

    constructor(private route: ActivatedRoute, private router: Router, private deliveryService: DeliveryService) { }

    ngOnInit(): void {
        this.getDelivery();
        localStorage.removeItem("delivery");
    }

    getDelivery(): void {
        const id = Number(this.route.snapshot.paramMap.get("id"));
        this.deliveryService.getDelivery(id)
            .subscribe(delivery => this.delivery = delivery);
    }

    startDelivery(): void {
        const id = Number(this.route.snapshot.paramMap.get("id"));
        this.deliveryService.startDelivery(id)
            .subscribe(delivery => {
                this.delivery = delivery;
                if(this.delivery) {
                    localStorage.setItem("delivery", id.toString());
                }
            });
    }

    updateDeliveryStatus(status: string): void {
        const id = Number(this.route.snapshot.paramMap.get("id"));
        this.deliveryService.updateDeliveryStatus(id, status)
            .subscribe(delivery => {
                this.delivery = delivery;
                if(this.delivery && status == 'Order delivered') {
                    localStorage.removeItem("delivery");
                    this.router.navigate(["/deliveries"]);
                }
            });
    }
}
