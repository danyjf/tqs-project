import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DeliveriesComponent } from './deliveries/deliveries.component';
import { DeliveryDetailsComponent } from './delivery-details/delivery-details.component';
import { ManagerStatisticsComponent } from './manager-statistics/manager-statistics.component';
import { RiderStatisticsComponent } from './rider-statistics/rider-statistics.component';

const routes: Routes = [
    { path: "", redirectTo: "/deliveries", pathMatch: "full" },
    { path: "deliveries", component: DeliveriesComponent },
    { path: "deliveries/:id", component: DeliveryDetailsComponent },
    { path: "statistics", component: RiderStatisticsComponent },
    { path: "manager/statistics", component: ManagerStatisticsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
