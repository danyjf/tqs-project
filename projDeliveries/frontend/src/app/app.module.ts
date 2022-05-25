import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';
import { DeliveriesComponent } from './deliveries/deliveries.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DeliveryDetailsComponent } from './delivery-details/delivery-details.component';
import { RiderStatisticsComponent } from './rider-statistics/rider-statistics.component';
import { ManagerStatisticsComponent } from './manager-statistics/manager-statistics.component';

@NgModule({
  declarations: [
    AppComponent,
    DeliveriesComponent,
    NavbarComponent,
    DeliveryDetailsComponent,
    RiderStatisticsComponent,
    ManagerStatisticsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: environment.production,
      // Register the ServiceWorker as soon as the application is stable
      // or after 30 seconds (whichever comes first).
      registrationStrategy: 'registerWhenStable:30000'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
