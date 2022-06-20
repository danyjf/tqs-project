import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { IDelivery } from '../interfaces/delivery';

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

    getFilteredDeliveries(delayed: boolean[], store: string[], status: number[]): Observable<IDelivery[]> {
        let parameters: string = "";

        for(const d of delayed) 
            parameters += `delayed=${d}&`;

        for(const s of store) 
            parameters += `store=${s}&`;

        for(const s of status) 
            parameters += `status=${s}&`;

        return this.http.get<IDelivery[]>(`http://localhost:8000/deliveries/filter?${parameters}`);
    }
}
