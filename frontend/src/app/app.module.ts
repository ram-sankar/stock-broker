import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ChartsModule } from 'ng2-charts';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { WatchListComponent } from './components/watch-list/watch-list.component';
import { BuyComponent } from './components/buy/buy.component';
import { HomeComponent } from './components/home/home.component';
import { MySharesComponent } from './components/my-shares/my-shares.component';
import { SellComponent } from './components/sell/sell.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ViewComponent } from './components/view/view.component'

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    WatchListComponent,
    BuyComponent,
    HomeComponent,
    MySharesComponent,
    SellComponent,
    ProfileComponent,
    ViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,    
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule, 
    ChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
