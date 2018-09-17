import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { MaterialModule } from './material.module';
import { AppRoutingModule } from './app-routing.module';
import { ProductCatalogService } from './service/product-catalog.service';
import { HttpClientModule } from '@angular/common/http';
import { NgxSoapModule } from 'ngx-soap';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    NgxSoapModule,
    HttpClientModule,
    MaterialModule,
    AppRoutingModule
  ],
  providers: [ProductCatalogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
