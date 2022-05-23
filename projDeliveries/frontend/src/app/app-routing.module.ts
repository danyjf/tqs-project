import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DeliveriesComponent } from './deliveries/deliveries.component';
import { DeliveryDetailsComponent } from './delivery-details/delivery-details.component';

const routes: Routes = [
    { path: "", redirectTo: "/deliveries", pathMatch: "full" },
    { path: "deliveries", component: DeliveriesComponent },
    { path: "deliveries/:id", component: DeliveryDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
