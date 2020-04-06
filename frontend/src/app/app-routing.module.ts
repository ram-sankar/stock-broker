import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { WatchListComponent } from './components/watch-list/watch-list.component';
import { BuyComponent } from './components/buy/buy.component';
import { SellComponent } from './components/sell/sell.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ViewComponent } from './components/view/view.component';
import { MySharesComponent } from './components/my-shares/my-shares.component';

export const AppRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'watch', component: WatchListComponent },
  { path: 'buy/:id', component: BuyComponent },
  { path: 'sell/:id', component: SellComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'view/:id', component: ViewComponent },
  { path: 'my-shares', component: MySharesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(AppRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
