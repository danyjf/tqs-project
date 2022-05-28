import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Delivery } from './delivery';
import { DELIVERIES } from './mock-deliveries';

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

    getFilteredDeliveries(delayed: string, store: string, status: string): Observable<Delivery[]> {
        let deliveries: Delivery[] = [];

        for(let delivery of DELIVERIES) {
            if(delayed == "delayed" && delivery.delayed || delayed == "notDelayed" && !delivery.delayed || delayed == "all") {
                if(store == delivery.store_name || store == "all") {
                    if(status == delivery.delivery_status || status == "all") {
                        deliveries.push(delivery);
                    }
                }
            }
        }
        
        return of(deliveries);
    }
}
