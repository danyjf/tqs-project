import { Component, OnInit } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';

import { DeliveryService } from '../services/delivery.service';
import { IDelivery } from '../interfaces/delivery';
import { IStore } from '../interfaces/store';

@Component({
    selector: 'app-manager-statistics',
    templateUrl: './manager-statistics.component.html',
    styleUrls: ['./manager-statistics.component.css']
})
export class ManagerStatisticsComponent implements OnInit {
    statusList: string[] = [];
    storeList: IStore[] = [];

    dropdownSettings: IDropdownSettings = {};

    statusDropdownList: Option[] = [];
    selectedStatus: Option[] = [];

    storeDropdownList: Option[] = [];
    selectedStore: Option[] = [];

    delayedDropdownList: Option[] = [];
    selectedDelayed: Option[] = [];

    deliveries: IDelivery[] = [];

    constructor(private deliveryService: DeliveryService) { }

    ngOnInit(): void {
        this.statusList = [
            "Waiting for rider",
            "Picking up the order",
            "Delivering the order",
            "Order delivered"
        ];

        this.dropdownSettings = {
            idField: "item_id",
            textField: "item_text",
            enableCheckAll: false
        }
        
        this.statusDropdownList = [
            { item_id: 0, item_text: this.statusList[0] },
            { item_id: 1, item_text: this.statusList[1] },
            { item_id: 2, item_text: this.statusList[2] },
            { item_id: 3, item_text: this.statusList[3] }
        ];

        this.deliveryService.getStores()
            .subscribe(stores => {
                this.storeList = stores;
                
                this.storeDropdownList = [];

                for(let i = 0; i < this.storeList.length; i++) {
                    this.storeDropdownList.push({ item_id: i, item_text: this.storeList[i].name })
                }
            });

        this.delayedDropdownList = [
            { item_id: 0, item_text: "Delayed" },
            { item_id: 1, item_text: "Not Delayed" },
        ]

        this.getDeliveries();
    }

    getDeliveries(): void {
        this.deliveryService.getDeliveries()
            .subscribe(deliveries => this.deliveries = deliveries);
    }

    getFilteredDeliveries(): void {
        let status = this.selectedStatus.map(s => s.item_id);
        if(status.length == 0)
            status = this.statusDropdownList.map(s => s.item_id);
        
        let store = this.selectedStore.map(s => s.item_text);
        if(store.length == 0)
            store = this.storeDropdownList.map(s => s.item_text);

        let delayed = this.selectedDelayed.map(s => s.item_text == "Delayed" ? true : false);
        if(delayed.length == 0)
            delayed = this.delayedDropdownList.map(s => s.item_text == "Delayed" ? true : false);

        this.deliveryService.getFilteredDeliveries(delayed, store, status)
            .subscribe(deliveries => this.deliveries = deliveries);
    }

    isComplete(deliveryStatus: string, elementStatus: string): string {
        let classes = "";
        
        if(this.statusList.indexOf(elementStatus) <= this.statusList.indexOf(deliveryStatus)) {
            classes = "completed";
        }
        
        return classes;
    }
}

interface Option {
    item_id: number;
    item_text: string;
}
