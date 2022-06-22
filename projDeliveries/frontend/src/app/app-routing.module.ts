import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DeliveriesComponent } from './deliveries/deliveries.component';
import { DeliveryDetailsComponent } from './delivery-details/delivery-details.component';
import { ManagerStatisticsComponent } from './manager-statistics/manager-statistics.component';
import { RiderStatisticsComponent } from './rider-statistics/rider-statistics.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './guards/auth.guard';
import { ManagerGuard } from './guards/manager.guard';
import { IsDeliveringGuard } from './guards/is-delivering.guard';

const routes: Routes = [
    { path: "", redirectTo: "/login", pathMatch: "full" },
    { path: "login", component: LoginComponent },
    { path: "register", component: RegisterComponent },
    { path: "deliveries", component: DeliveriesComponent, canActivate: [AuthGuard, IsDeliveringGuard] },
    { path: "deliveries/:id", component: DeliveryDetailsComponent, canActivate: [AuthGuard] },
    { path: "statistics", component: RiderStatisticsComponent, canActivate: [AuthGuard] },
    { path: "manager/statistics", component: ManagerStatisticsComponent, canActivate: [ManagerGuard] },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
