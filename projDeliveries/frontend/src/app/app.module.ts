import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { ServiceWorkerModule } from '@angular/service-worker';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { environment } from '../environments/environment';
import { DeliveriesComponent } from './deliveries/deliveries.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DeliveryDetailsComponent } from './delivery-details/delivery-details.component';
import { RiderStatisticsComponent } from './rider-statistics/rider-statistics.component';
import { ManagerStatisticsComponent } from './manager-statistics/manager-statistics.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { ManagerGuard } from './guards/manager.guard';

@NgModule({
  declarations: [
    AppComponent,
    DeliveriesComponent,
    NavbarComponent,
    DeliveryDetailsComponent,
    RiderStatisticsComponent,
    ManagerStatisticsComponent,
    RegisterComponent,
    LoginComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgMultiSelectDropDownModule.forRoot(),
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: environment.production,
      // Register the ServiceWorker as soon as the application is stable
      // or after 30 seconds (whichever comes first).
      registrationStrategy: 'registerWhenStable:30000'
    })
  ],
  providers: [AuthGuard, ManagerGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
