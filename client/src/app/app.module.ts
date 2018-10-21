import { NgModule                         } from '@angular/core';
import { BrowserModule                    } from '@angular/platform-browser';
import { BrowserAnimationsModule          } from '@angular/platform-browser/animations';
import { HttpClientModule                 } from '@angular/common/http';
import { registerLocaleData               } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import en from '@angular/common/locales/en';

import { NgZorroAntdModule, NZ_I18N, en_US } from 'ng-zorro-antd';

import { AppComponent  } from './app.component';
import { HomeComponent } from './component/home/home.component';

import { ProductService        } from './service/product.service';
import { ProductCatalogService } from './service/product-catalog.service';
import { InfoService           } from './service/info.service';

import { AppRoutingModule      } from './app-routing.module';
import { AboutComponent        } from './component/about/about.component';
import { ProductCardComponent  } from './component/product-card/product-card.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { UsersComponent        } from './component/users/users.component';
import { LoginComponent } from './component/login/login.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UsersComponent,
    AboutComponent,
    ProductCardComponent,
    PageNotFoundComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgZorroAntdModule,
    AppRoutingModule
  ],
  providers: [
    ProductService,
    ProductCatalogService,
    InfoService,
    { provide: NZ_I18N, useValue: en_US }
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
