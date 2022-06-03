import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Delivery } from './models/delivery';
import { DELIVERIES } from './models/mock-deliveries';

@Injectable({
    providedIn: 'root'
})
export class DeliveryService {
    constructor() { }

    getDeliveries(): Observable<Delivery[]> {
        const deliveries = of(DELIVERIES);
        return deliveries;
    }

    getDelivery(id: number): Observable<Delivery> {
        const delivery = DELIVERIES.find(d => d.id === id)!;
        return of(delivery);
    }

    getPendingDeliveries(): Observable<Delivery[]> {
        let deliveries: Delivery[] = [];
        
        for(let delivery of DELIVERIES) {
            if(delivery.delivery_status === "Waiting for rider")
                deliveries.push(delivery);
        }
        
        return of(deliveries);
    }

    getFilteredDeliveries(delayed: string[], store: string[], status: string[]): Observable<Delivery[]> {
        let deliveries: Delivery[] = [];

        for(let delivery of DELIVERIES) {
            if(delayed.length == 0 || delayed.includes("Delayed") && delivery.delayed || delayed.includes("Not Delayed") && !delivery.delayed) {
                if(store.length == 0 || store.includes(delivery.store_name)) {
                    if(status.length == 0 || status.includes(delivery.delivery_status)) {
                        deliveries.push(delivery);
                    }
                }
            }
        }

        return of(deliveries);
    }
}
