import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DeliveriesComponent } from './deliveries/deliveries.component';

const routes: Routes = [
    { path: "", redirectTo: "/deliveries", pathMatch: "full" },
    { path: "deliveries", component: DeliveriesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
