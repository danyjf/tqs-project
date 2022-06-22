import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { IDelivery } from '../interfaces/delivery';
import { IStore } from '../interfaces/store';

@Injectable({
    providedIn: 'root'
})
export class DeliveryService {
    url: string = "api"

    constructor(private http: HttpClient) { }

    getDeliveries(): Observable<IDelivery[]> {
        return this.http.get<IDelivery[]>(`${this.url}/deliveries`);
    }

    getDelivery(id: number): Observable<IDelivery> {
        return this.http.get<IDelivery>(`${this.url}/deliveries/${id}`);
    }

    getPendingDeliveries(): Observable<IDelivery[]> {
        return this.http.get<IDelivery[]>(`${this.url}/deliveries/status/Waiting for rider`);
    }

    getFilteredDeliveries(delayed: boolean[], store: string[], status: number[]): Observable<IDelivery[]> {
        let parameters: string = "";

        for(const d of delayed) 
            parameters += `delayed=${d}&`;

        for(const s of store) 
            parameters += `store=${s}&`;

        for(const s of status) 
            parameters += `status=${s}&`;

        return this.http.get<IDelivery[]>(`${this.url}/deliveries/filter?${parameters}`);
    }

    getStores(): Observable<IStore[]> {
        return this.http.get<IStore[]>("${this.url}/stores");
    }

    startDelivery(id: number): Observable<IDelivery> {
        return this.http.post<IDelivery>(`${this.url}/delivery/rider?deliveryId=${id}&riderPhone=${localStorage.getItem("userPhone")}`, null);
    }

    getOnGoingDelivery(phone: string): Observable<IDelivery> {
        return this.http.get<IDelivery>(`${this.url}/delivery/rider/status?riderPhone=${phone}&status=0&status=1&status=2`);
    }

    updateDeliveryStatus(id: number, status: string): Observable<IDelivery> {
        return this.http.put<IDelivery>(`${this.url}/delivery/${id}/status/${status}`, null);
    }
}
