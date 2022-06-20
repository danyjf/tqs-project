import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { IDelivery } from '../interfaces/delivery';
import { DELIVERIES } from '../interfaces/mock-deliveries';

@Injectable({
    providedIn: 'root'
})
export class DeliveryService {
    constructor(private http: HttpClient) { }

    getDeliveries(): Observable<IDelivery[]> {
        return this.http.get<IDelivery[]>(`http://localhost:8000/deliveries`);
    }

    getDelivery(id: number): Observable<IDelivery> {
        return this.http.get<IDelivery>(`http://localhost:8000/deliveries/${id}`);
    }

    getPendingDeliveries(): Observable<IDelivery[]> {
        return this.http.get<IDelivery[]>(`http://localhost:8000/deliveries/status/Waiting for rider`);
    }

    getFilteredDeliveries(delayed: string[], store: string[], status: string[]): Observable<IDelivery[]> {
        let deliveries: IDelivery[] = [];

        // for(let delivery of DELIVERIES) {
        //     if(delayed.length == 0 || delayed.includes("Delayed") && delivery.delayed || delayed.includes("Not Delayed") && !delivery.delayed) {
        //         if(store.length == 0 || store.includes(delivery.store_name)) {
        //             if(status.length == 0 || status.includes(delivery.delivery_status)) {
        //                 deliveries.push(delivery);
        //             }
        //         }
        //     }
        // }

        return of(deliveries);
    }
}
