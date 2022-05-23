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
}
