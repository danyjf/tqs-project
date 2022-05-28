import { Component, OnInit } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';

import { DeliveryService } from '../delivery.service';
import { Delivery } from '../delivery';

@Component({
    selector: 'app-manager-statistics',
    templateUrl: './manager-statistics.component.html',
    styleUrls: ['./manager-statistics.component.css']
})
export class ManagerStatisticsComponent implements OnInit {
    dropdownSettings: IDropdownSettings = {};

    statusDropdownList: Option[] = [];
    selectedStatus: Option[] = [];

    storeDropdownList: Option[] = [];
    selectedStore: Option[] = [];

    delayedDropdownList: Option[] = [];
    selectedDelayed: Option[] = [];

    deliveries: Delivery[] = [];

    constructor(private deliveryService: DeliveryService) { }

    ngOnInit(): void {
        this.dropdownSettings = {
            idField: "item_id",
            textField: "item_text",
            enableCheckAll: false
        }
        
        this.statusDropdownList = [
            { item_id: 1, item_text: "Waiting for rider" },
            { item_id: 2, item_text: "Picking up the order" },
            { item_id: 3, item_text: "Delivering the order" },
            { item_id: 4, item_text: "Order delivered" }
        ];

        this.storeDropdownList = [
            { item_id: 1, item_text: "Music" },
            { item_id: 2, item_text: "Food" },
            { item_id: 3, item_text: "Medicine" }
        ];

        this.delayedDropdownList = [
            { item_id: 1, item_text: "Delayed" },
            { item_id: 2, item_text: "Not Delayed" },
        ]

        this.getFilteredDeliveries();
    }

    getFilteredDeliveries(): void {
        let status = this.selectedStatus.map(s => s.item_text);
        let store = this.selectedStore.map(s => s.item_text);
        let delayed = this.selectedDelayed.map(s => s.item_text);
        this.deliveryService.getFilteredDeliveries(delayed, store, status)
            .subscribe(deliveries => this.deliveries = deliveries);
    }
}

interface Option {
    item_id: number;
    item_text: string;
}
